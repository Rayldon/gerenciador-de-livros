package br.jus.tjrj.gerenciadorlivro.domain.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vw_Livro_Relatorio")  // Nome da sua view no banco de dados
public class LivroRelatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro", nullable = false)
    private Long id;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Editora")
    private String editora;

    @Column(name = "Edicao")
    private Integer edicao;

    @Column(name = "Ano_Publicacao")
    private String anoPublicacao;

    @Column(name = "Autor_Nome")
    private String autorNome;

    @Column(name = "Assunto_Descricao")
    private String assuntoDescricao;

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

    public String getAutorNome() {
        return autorNome;
    }

    public void setAutorNome(String autorNome) {
        this.autorNome = autorNome;
    }

    public String getAssuntoDescricao() {
        return assuntoDescricao;
    }

    public void setAssuntoDescricao(String assuntoDescricao) {
        this.assuntoDescricao = assuntoDescricao;
    }
}