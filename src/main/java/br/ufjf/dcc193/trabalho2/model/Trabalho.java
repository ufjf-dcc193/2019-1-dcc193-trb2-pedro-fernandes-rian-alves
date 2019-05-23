package br.ufjf.dcc193.trabalho2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;

    @OneToMany
    private List<Revisao> revisoes;

    @OneToMany
    private List<AreaConhecimento> areaConhecimento;
    
} 