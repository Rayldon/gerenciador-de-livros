package br.jus.tjrj.gerenciadorlivro.domain.entidade;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Livro_Assunto")
@IdClass(LivroAssuntoId.class) // Usando uma chave composta
public class LivroAssunto {

    @Id
    @ManyToOne
    @JoinColumn(name = "Livro_Cod")
    private Livro livro;

    @Id
    @ManyToOne
    @JoinColumn(name = "Assunto_codAs")
    private Assunto assunto;

    // Getters e Setters
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }
}

