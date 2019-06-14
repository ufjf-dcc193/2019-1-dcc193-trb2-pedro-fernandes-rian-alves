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
   
    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

  
    public String getEmail() {
        return email;
    }
    
    public Integer getCodigo() {
        return codigo;
    }
  
    public List<AreaConhecimento> getAreaConhecimento() {
        return areaConhecimento;
    }

    public List<Revisao> getRevisoes() {
        return revisoes;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setAreaConhecimento(List<AreaConhecimento> areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }
    public void setRevisoes(List<Revisao> revisoes) {
        this.revisoes = revisoes;
    }
} 