package br.ufjf.dcc193.trabalho2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AreaConhecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String area;
    private String desc;

    @OneToMany
    private List<Trabalho> trabalhos;

    @OneToMany
    private List<Avaliador> avaliadores;
}