package br.jus.tjrj.gerenciadorlivro.adapters.controller;

import br.jus.tjrj.gerenciadorlivro.domain.service.LivroRelatorioService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/relatorio")
public class LivroRelatorioController {

    final LivroRelatorioService livroRelatorioService;

    public LivroRelatorioController(LivroRelatorioService livroRelatorioService) {
        this.livroRelatorioService = livroRelatorioService;
    }

    @GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> gerarRelatorioDeLivros() {
        byte[] relatorio = livroRelatorioService.gerarRelatorio();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relatorio_livros.pdf")
                .body(relatorio);
    }
}
