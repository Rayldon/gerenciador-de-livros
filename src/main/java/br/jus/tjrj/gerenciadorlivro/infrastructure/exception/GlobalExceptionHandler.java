package br.jus.tjrj.gerenciadorlivro.infrastructure.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GerenciadoLivroException.class)
    public ResponseEntity<String> handleGerenciadoLivroException(GerenciadoLivroException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

