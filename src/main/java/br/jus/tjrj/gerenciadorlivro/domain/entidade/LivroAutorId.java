package br.jus.tjrj.gerenciadorlivro.domain.entidade;

import java.io.Serializable;
import java.util.Objects;

public class LivroAutorId implements Serializable {

    private Integer livro;
    private Integer autor;

    // Getters e Setters
    public Integer getLivro() {
        return livro;
    }

    public void setLivro(Integer livro) {
        this.livro = livro;
    }

    public Integer getAutor() {
        return autor;
    }

    public void setAutor(Integer autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivroAutorId that = (LivroAutorId) o;
        return Objects.equals(livro, that.livro) && Objects.equals(autor, that.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livro, autor);
    }
}
