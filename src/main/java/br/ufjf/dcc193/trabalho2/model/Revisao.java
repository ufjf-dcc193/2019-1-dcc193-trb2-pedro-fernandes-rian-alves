package br.ufjf.dcc193.trabalho2.model;

import javax.persistence.*;

@Entity
public class Revisao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private Avaliador avaliador;

    @OneToOne
    private Trabalho trabalho;

    private Integer nota;
    private String descricao;
    private Status status;
} 