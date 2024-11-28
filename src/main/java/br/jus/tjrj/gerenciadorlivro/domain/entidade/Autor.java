package br.jus.tjrj.gerenciadorlivro.domain.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodAu")
    private Integer codAu;

    @Column(name = "Nome", length = 40)
    private String nome;

    public Integer getCodAu() {
        return codAu;
    }

    public void setCodAu(Integer codAu) {
        this.codAu = codAu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

