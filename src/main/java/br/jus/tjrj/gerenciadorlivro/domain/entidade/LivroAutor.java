package br.jus.tjrj.gerenciadorlivro.domain.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Livro_Autor")
@IdClass(LivroAutorId.class) // Usando uma chave composta
public class LivroAutor {

    @Id
    @ManyToOne
    @JoinColumn(name = "Livro_Cod")
    private Livro livro;

    @Id
    @ManyToOne
    @JoinColumn(name = "Autor_CodAu")
    private Autor autor;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}

