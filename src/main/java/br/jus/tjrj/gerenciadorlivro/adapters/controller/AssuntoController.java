package br.jus.tjrj.gerenciadorlivro.adapters.controller;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AssuntoDTO;
import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutoCompleteDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Assunto;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import br.jus.tjrj.gerenciadorlivro.domain.service.AssuntoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/assunto")
public class AssuntoController {

    final AssuntoService assuntoService;

    public AssuntoController(AssuntoService assuntoService) {
        this.assuntoService = assuntoService;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Assunto> salvar(@RequestBody AssuntoDTO assuntoDTO) {
        Assunto assunto = assuntoService.salvar(assuntoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(assunto);
    }

    @GetMapping(produces = "application/json")
    public Page<Assunto> listarAssuntoes(@RequestParam(defaultValue = "") String descricao,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return assuntoService.buscarAssuntos(descricao, pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAssunto(@PathVariable Long id) {
        assuntoService.excluirAssunto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/todos", produces = "application/json")
    public ResponseEntity<List<Assunto>> listarTodosAssuntos() {
        return ResponseEntity.status(HttpStatus.OK).body(assuntoService.buscarTodosAssuntos());
    }

    @GetMapping(value = "/autocomplete/{searchQuery}", produces = "application/json")
    public ResponseEntity<List<AutoCompleteDTO>> autoComplete(@PathVariable String searchQuery) {
        List<AutoCompleteDTO> autores = assuntoService.autoComplete(searchQuery);
        return ResponseEntity.status(HttpStatus.OK).body(autores);
    }
}
