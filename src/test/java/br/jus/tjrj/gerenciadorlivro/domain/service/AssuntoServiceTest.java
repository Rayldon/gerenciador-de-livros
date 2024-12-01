package br.jus.tjrj.gerenciadorlivro.domain.service;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AssuntoDTO;
import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutoCompleteDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Assunto;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.AssuntoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AssuntoServiceTest {

    @Mock
    private AssuntoRepository assuntoRepository;

    @InjectMocks
    private AssuntoService assuntoService;

    private AssuntoDTO assuntoDTO;
    private Assunto assunto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        assuntoDTO = new AssuntoDTO();
        assuntoDTO.setDescricao("Test Description");

        assunto = new Assunto();
        assunto.setDescricao("Test Description");
    }

    @Test
    void testSalvar() {
        when(assuntoRepository.salvar(any(Assunto.class))).thenReturn(assunto);
        Assunto result = assuntoService.salvar(assuntoDTO);

        assertNotNull(result);
        assertEquals("Test Description", result.getDescricao());
        verify(assuntoRepository, times(1)).salvar(any(Assunto.class));
    }

    @Test
    void testBuscarAssuntos() {
        Pageable pageable = Pageable.unpaged();
        Page<Assunto> page = new PageImpl<>(List.of(assunto));
        when(assuntoRepository.consultaPaginada(anyString(), eq(pageable))).thenReturn(page);

        Page<Assunto> result = assuntoService.buscarAssuntos("Test", pageable);
        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        verify(assuntoRepository, times(1)).consultaPaginada(anyString(), eq(pageable));
    }

    @Test
    void testExcluirAssunto() {
        Long id = 1L;
        doNothing().when(assuntoRepository).excluirPorId(id);
        assuntoService.excluirAssunto(id);
        verify(assuntoRepository, times(1)).excluirPorId(id);
    }

    @Test
    void testBuscarTodosAssuntos() {
        when(assuntoRepository.buscarTodos()).thenReturn(List.of(assunto));
        List<Assunto> result = assuntoService.buscarTodosAssuntos();
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(assuntoRepository, times(1)).buscarTodos();
    }

    @Test
    void testAutoComplete() {
        String searchQuery = "Teste";
        List<AutoCompleteDTO> autoCompleteList = List.of(new AutoCompleteDTO(1L, "Teste"));
        when(assuntoRepository.autoComplete(searchQuery)).thenReturn(autoCompleteList);

        List<AutoCompleteDTO> result = assuntoService.autoComplete(searchQuery);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Teste", result.get(0).getDescricao());
        verify(assuntoRepository, times(1)).autoComplete(searchQuery);
    }
}

