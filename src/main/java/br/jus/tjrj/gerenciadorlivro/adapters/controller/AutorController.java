package br.jus.tjrj.gerenciadorlivro.adapters.controller;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutoCompleteDTO;
import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutorDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import br.jus.tjrj.gerenciadorlivro.domain.service.AutorService;
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
@RequestMapping("/api/autor")
public class AutorController {

    final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<Autor> salvar(@RequestBody AutorDTO autorDTO) {
        Autor autor = autorService.salvar(autorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(autor);
    }

    @GetMapping
    public Page<Autor> listarAutores(@RequestParam(defaultValue = "") String nome,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return autorService.buscarAutores(nome, pageable);
    }

    @GetMapping("/autocomplete/{searchQuery}")
    public ResponseEntity<List<AutoCompleteDTO>> autoComplete(@PathVariable String searchQuery) {
        List<AutoCompleteDTO> autores = autorService.autoComplete(searchQuery);
        return ResponseEntity.status(HttpStatus.OK).body(autores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAutor(@PathVariable Long id) {
        autorService.excluirAutor(id);
        return ResponseEntity.noContent().build();
    }
}
