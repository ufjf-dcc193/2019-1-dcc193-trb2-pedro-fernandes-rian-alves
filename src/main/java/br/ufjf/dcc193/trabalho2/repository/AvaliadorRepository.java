package br.ufjf.dcc193.trabalho2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufjf.dcc193.trabalho2.model.Avaliador;

@Repository
public interface AvaliadorRepository extends CrudRepository<Avaliador,Long> {
    
}
