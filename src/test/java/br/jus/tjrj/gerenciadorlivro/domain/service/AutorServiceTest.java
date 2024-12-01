package br.jus.tjrj.gerenciadorlivro.domain.service;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutoCompleteDTO;
import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutorDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.AutorRepository;
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

class AutorServiceTest {

    @Mock
    private AutorRepository autorRepository;

    @InjectMocks
    private AutorService autorService;

    private AutorDTO autorDTO;
    private Autor autor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        autorDTO = new AutorDTO();
        autorDTO.setNome("Autor Teste");

        autor = new Autor();
        autor.setNome("Autor Teste");
    }

    @Test
    void testSalvar() {
        when(autorRepository.salvar(any(Autor.class))).thenReturn(autor);

        Autor result = autorService.salvar(autorDTO);

        assertNotNull(result);
        assertEquals("Autor Teste", result.getNome());
        verify(autorRepository, times(1)).salvar(any(Autor.class));
    }

    @Test
    void testBuscarAutores() {
        Pageable pageable = Pageable.unpaged();
        Page<Autor> page = new PageImpl<>(List.of(autor));
        when(autorRepository.consultaPaginada(anyString(), eq(pageable))).thenReturn(page);

        Page<Autor> result = autorService.buscarAutores("Teste", pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        verify(autorRepository, times(1)).consultaPaginada(anyString(), eq(pageable));
    }

    @Test
    void testAutoComplete() {
        String searchQuery = "Teste";
        List<AutoCompleteDTO> autoCompleteList = List.of(new AutoCompleteDTO(1L,"Teste"));
        when(autorRepository.autoComplete(searchQuery)).thenReturn(autoCompleteList);

        List<AutoCompleteDTO> result = autorService.autoComplete(searchQuery);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Teste", result.get(0).getDescricao());
        verify(autorRepository, times(1)).autoComplete(searchQuery);
    }

    @Test
    void testExcluirAutor() {
        Long id = 1L;
        doNothing().when(autorRepository).excluirPorId(id);

        autorService.excluirAutor(id);

        verify(autorRepository, times(1)).excluirPorId(id);
    }
}