package br.jus.tjrj.gerenciadorlivro.domain.entidade;

import java.io.Serializable;
import java.util.Objects;

public class LivroAssuntoId implements Serializable {

    private Integer livro;
    private Integer assunto;

    // Getters e Setters
    public Integer getLivro() {
        return livro;
    }

    public void setLivro(Integer livro) {
        this.livro = livro;
    }

    public Integer getAssunto() {
        return assunto;
    }

    public void setAssunto(Integer assunto) {
        this.assunto = assunto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivroAssuntoId that = (LivroAssuntoId) o;
        return Objects.equals(livro, that.livro) && Objects.equals(assunto, that.assunto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livro, assunto);
    }
}

