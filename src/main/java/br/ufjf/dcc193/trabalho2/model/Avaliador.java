package br.ufjf.dcc193.trabalho2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Avaliador  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String email;
    private String nome;
    
    private String codigo;
 
    @OneToOne
    AreaConhecimento areaConhecimento;

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

    public String getCodigo() {
        return codigo;
    }

    public AreaConhecimento getAreaConhecimento() {
        return areaConhecimento;
    }

    public List<Revisao> getRevisoes() {
        return revisoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public void setRevisoes(List<Revisao> revisoes) {
        this.revisoes = revisoes;
    }

    

} 