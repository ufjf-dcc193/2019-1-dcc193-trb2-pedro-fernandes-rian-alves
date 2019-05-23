package br.ufjf.dcc193.trabalho2.repository;

import br.ufjf.dcc193.trabalho2.model.Revisao;
import br.ufjf.dcc193.trabalho2.model.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabalhoRepository extends JpaRepository<Trabalho,Long> {
}
