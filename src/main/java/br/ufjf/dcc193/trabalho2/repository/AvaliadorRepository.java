package br.ufjf.dcc193.trabalho2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufjf.dcc193.trabalho2.model.Avaliador;

@Repository
public interface AvaliadorRepository extends JpaRepository<Avaliador,String> {
    Avaliador findOneByEmailAndCodigo(String email, String codigo);
}
