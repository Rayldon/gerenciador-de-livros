package br.jus.tjrj.gerenciadorlivro.domain.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codl")
    private Long id;

    @Column(name = "Titulo", length = 40)
    private String titulo;

    @Column(name = "Editora", length = 40)
    private String editora;

    @Column(name = "Edicao")
    private Integer edicao;

    @Column(name = "AnoPublicacao", length = 4)
    private String anoPublicacao;

    @ManyToMany
    @JoinTable(name = "livro_autor", joinColumns = @JoinColumn(name = "Livro_Cod"),
            inverseJoinColumns = @JoinColumn(name = "Autor_CodAu"))
    private Set<Autor> autores = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "Livro_Assunto", joinColumns = @JoinColumn(name = "Livro_Cod"),
            inverseJoinColumns = @JoinColumn(name = "Assunto_codAs")
    )
    private Set<Assunto> assuntos = new HashSet<>();

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

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    public Set<Assunto> getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(Set<Assunto> assuntos) {
        this.assuntos = assuntos;
    }
}

