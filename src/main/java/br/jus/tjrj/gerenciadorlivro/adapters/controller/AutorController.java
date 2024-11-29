package br.jus.tjrj.gerenciadorlivro.adapters.controller;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutorDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import br.jus.tjrj.gerenciadorlivro.domain.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
