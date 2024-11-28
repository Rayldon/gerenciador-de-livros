package br.jus.tjrj.gerenciadorlivro.domain.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Assunto")
public class Assunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codAs")
    private Integer codAs;

    @Column(name = "Descricao", length = 20)
    private String descricao;

    public Integer getCodAs() {
        return codAs;
    }

    public void setCodAs(Integer codAs) {
        this.codAs = codAs;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

