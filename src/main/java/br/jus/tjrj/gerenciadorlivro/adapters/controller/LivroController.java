package br.jus.tjrj.gerenciadorlivro.adapters.controller;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.LivroDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Livro;
import br.jus.tjrj.gerenciadorlivro.domain.service.LivroService;
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

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<Livro> salvar(@RequestBody LivroDTO livroDTO) {
        Livro livro = livroService.salvar(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(livro);
    }

    @GetMapping
    public Page<Livro> listarLivros(@RequestParam(defaultValue = "") String titulo,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return livroService.buscarLivros(titulo, pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLivro(@PathVariable Long id) {
        livroService.excluirLivro(id);
        return ResponseEntity.noContent().build();
    }
}
