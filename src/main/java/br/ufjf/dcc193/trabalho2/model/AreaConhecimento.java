package br.ufjf.dcc193.trabalho2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AreaConhecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String area;
    private String descricao;

    @OneToMany
    private List<Trabalho> trabalhos;

    @OneToMany
    private List<Avaliador> avaliadores;

    public Long getId() {
        return id;
    }

     public String getArea() {
        return area;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}