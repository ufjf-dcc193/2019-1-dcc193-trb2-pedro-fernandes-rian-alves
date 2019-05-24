package br.ufjf.dcc193.trabalho2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Avaliador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String email;
    private Integer codigo;

    @OneToMany
    private List<AreaConhecimento> areaConhecimento;

    @OneToMany
    private List<Revisao> revisoes;
    
} 