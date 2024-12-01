package br.jus.tjrj.gerenciadorlivro.adapters.dto;

import org.springframework.http.HttpStatus;
import java.util.Map;

public class ApiError {

    private HttpStatus status;
    private String mensagem;
    private Map<String, String> detalhes;

    public ApiError(HttpStatus status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Map<String, String> getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(Map<String, String> detalhes) {
        this.detalhes = detalhes;
    }
}

