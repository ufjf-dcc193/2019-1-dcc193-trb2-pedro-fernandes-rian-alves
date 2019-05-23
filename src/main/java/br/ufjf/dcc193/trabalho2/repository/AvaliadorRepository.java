package br.ufjf.dcc193.trabalho2.repository;

import br.ufjf.dcc193.trabalho2.model.Avaliador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliadorRepository extends JpaRepository<Avaliador,Long> {
}
