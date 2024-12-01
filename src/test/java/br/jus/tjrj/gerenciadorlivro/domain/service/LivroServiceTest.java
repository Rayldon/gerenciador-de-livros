package br.jus.tjrj.gerenciadorlivro.domain.service;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.LivroDTO;
import br.jus.tjrj.gerenciadorlivro.adapters.mapper.LivroMapper;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Assunto;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Livro;
import br.jus.tjrj.gerenciadorlivro.domain.repositorio.LivroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

class LivroServiceTest {

    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private LivroService livroService;

    private LivroDTO livroDTO;
    private Livro livro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        livroDTO = new LivroDTO();
        livroDTO.setTitulo("Livro Teste");
        livroDTO.setAutoresIds(Set.of(1L));
        livroDTO.setAssuntosIds(Set.of(1L));

        livro = new Livro();
        livro.setTitulo("Livro Teste");

        Autor autor1 = new Autor();
        autor1.setId(1L);
        livro.setAutores(Set.of(autor1));

        Assunto assunto = new Assunto();
        assunto.setId(1L);
        livro.setAssuntos(Set.of(assunto));
    }

    @Test
    void testSalvar() {
        when(livroRepository.salvar(any(Livro.class))).thenReturn(livro);

        Livro result = livroService.salvar(livroDTO);

        assertNotNull(result);
        assertEquals("Livro Teste", result.getTitulo());
        verify(livroRepository, times(1)).salvar(livro);
    }

    @Test
    void testBuscarLivros() {
        Pageable pageable = Pageable.unpaged();
        Page<Livro> page = new PageImpl<>(List.of(livro));
        when(livroRepository.consultaPaginada(anyString(), eq(pageable))).thenReturn(page);

        Page<Livro> result = livroService.buscarLivros("Teste", pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        verify(livroRepository, times(1)).consultaPaginada(anyString(), eq(pageable));
    }

    @Test
    void testExcluirLivro() {
        Long id = 1L;
        doNothing().when(livroRepository).excluirPorId(id);

        livroService.excluirLivro(id);

        verify(livroRepository, times(1)).excluirPorId(id);
    }
}