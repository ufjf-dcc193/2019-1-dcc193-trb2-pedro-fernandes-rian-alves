package br.ufjf.dcc193.trabalho2.repository;

import br.ufjf.dcc193.trabalho2.model.AreaConhecimento;
import br.ufjf.dcc193.trabalho2.model.Revisao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaConhecimentoRepository extends JpaRepository<AreaConhecimento,Long> {
}
