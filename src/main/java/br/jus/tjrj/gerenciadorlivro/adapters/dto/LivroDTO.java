package br.jus.tjrj.gerenciadorlivro.adapters.dto;

import java.util.Set;

public class LivroDTO {
    private Long id;
    private String titulo;
    private String editora;
    private Integer edicao;
    private String anoPublicacao;
    private Set<Long> autoresIds;
    private Set<Long> assuntosIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Set<Long> getAutoresIds() {
        return autoresIds;
    }

    public void setAutoresIds(Set<Long> autoresIds) {
        this.autoresIds = autoresIds;
    }

    public Set<Long> getAssuntosIds() {
        return assuntosIds;
    }

    public void setAssuntosIds(Set<Long> assuntosIds) {
        this.assuntosIds = assuntosIds;
    }
}
