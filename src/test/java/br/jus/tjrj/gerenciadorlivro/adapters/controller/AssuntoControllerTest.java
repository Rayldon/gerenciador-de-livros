package br.jus.tjrj.gerenciadorlivro.adapters.controller;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AssuntoDTO;
import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutoCompleteDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Assunto;
import br.jus.tjrj.gerenciadorlivro.domain.service.AssuntoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
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

class AssuntoControllerTest {

    @Mock
    private AssuntoService assuntoService;

    @InjectMocks
    private AssuntoController assuntoController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(assuntoController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testSalvar() throws Exception {
        AssuntoDTO assuntoDTO = new AssuntoDTO();
        assuntoDTO.setDescricao("Teste de Assunto");

        Assunto assunto = new Assunto();
        assunto.setId(1L);
        assunto.setDescricao("Teste de Assunto");

        when(assuntoService.salvar(any(AssuntoDTO.class))).thenReturn(assunto);

        mockMvc.perform(post("/api/assunto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(assuntoDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.descricao").value("Teste de Assunto"));

        verify(assuntoService, times(1)).salvar(any(AssuntoDTO.class));
    }

    @Test
    void testListarAssuntos() throws Exception {
        Assunto assunto = new Assunto();
        assunto.setId(1L);
        assunto.setDescricao("Teste de Assunto");

        Page<Assunto> page = new PageImpl<>(List.of(assunto), PageRequest.of(0, 10), 1);

        when(assuntoService.buscarAssuntos(anyString(), any(PageRequest.class))).thenReturn(page);

        mockMvc.perform(get("/api/assunto")
                        .param("descricao", "Teste")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1L))
                .andExpect(jsonPath("$.content[0].descricao").value("Teste de Assunto"));

        verify(assuntoService, times(1)).buscarAssuntos(anyString(), any(PageRequest.class));
    }

    @Test
    void testExcluirAssunto() throws Exception {
        doNothing().when(assuntoService).excluirAssunto(1L);

        mockMvc.perform(delete("/api/assunto/1"))
                .andExpect(status().isNoContent());

        verify(assuntoService, times(1)).excluirAssunto(1L);
    }

    @Test
    void testListarTodosAssuntos() throws Exception {
        Assunto assunto = new Assunto();
        assunto.setId(1L);
        assunto.setDescricao("Teste de Assunto");

        when(assuntoService.buscarTodosAssuntos()).thenReturn(List.of(assunto));

        String responseJson = mockMvc.perform(get("/api/assunto/todos"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        String expectedJson = "[{\"id\":1,\"descricao\":\"Teste de Assunto\"}]";
        assertEquals(expectedJson, responseJson);
        verify(assuntoService, times(1)).buscarTodosAssuntos();
    }

    @Test
    void testAutoComplete() throws Exception {
        AutoCompleteDTO autoCompleteDTO = new AutoCompleteDTO(1L, "Teste de Autocomplete");

        when(assuntoService.autoComplete("Teste")).thenReturn(List.of(autoCompleteDTO));

        mockMvc.perform(get("/api/assunto/autocomplete/Teste"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].descricao").value("Teste de Autocomplete"));

        verify(assuntoService, times(1)).autoComplete("Teste");
    }
}

