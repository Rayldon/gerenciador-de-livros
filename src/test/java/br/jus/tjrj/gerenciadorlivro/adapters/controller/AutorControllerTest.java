package br.jus.tjrj.gerenciadorlivro.adapters.controller;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutoCompleteDTO;
import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutorDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import br.jus.tjrj.gerenciadorlivro.domain.service.AutorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AutorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AutorService autorService;

    @InjectMocks
    private AutorController autorController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(autorController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testSalvarAutor() throws Exception {
        AutorDTO autorDTO = new AutorDTO();
        autorDTO.setNome("Autor Teste");

        Autor autor = new Autor();
        autor.setId(1L);
        autor.setNome("Autor Teste");

        when(autorService.salvar(any(AutorDTO.class))).thenReturn(autor);

        mockMvc.perform(post("/api/autor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(autorDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Autor Teste"));
    }

    @Test
    void testListarAutores() throws Exception {
        Autor autor = new Autor();
        autor.setId(1L);
        autor.setNome("Autor Teste");

        Page<Autor> autorPage = new PageImpl<>(List.of(autor));
        when(autorService.buscarAutores(anyString(), any(Pageable.class))).thenReturn(autorPage);

        // Passando parâmetros de consulta corretamente
        String responseJson = mockMvc.perform(get("/api/autor")
                        .param("nome", "Autor Teste")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertTrue(responseJson.contains("Autor Teste"));

        verify(autorService, times(1)).buscarAutores(eq("Autor Teste"), any(Pageable.class));
    }


    @Test
    void testAutoComplete() throws Exception {
        AutoCompleteDTO autoCompleteDTO = new AutoCompleteDTO(1L, "Autor Teste");

        when(autorService.autoComplete(anyString())).thenReturn(List.of(autoCompleteDTO));

        mockMvc.perform(get("/api/autor/autocomplete/{searchQuery}", "Autor")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].descricao").value("Autor Teste"));
    }

    @Test
    void testExcluirAutor() throws Exception {
        doNothing().when(autorService).excluirAutor(anyLong());

        mockMvc.perform(delete("/api/autor/{id}", 1L))
                .andExpect(status().isNoContent());

        verify(autorService, times(1)).excluirAutor(1L);
    }
}
