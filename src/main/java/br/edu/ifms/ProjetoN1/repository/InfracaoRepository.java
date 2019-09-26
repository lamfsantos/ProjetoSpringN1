package br.edu.ifms.ProjetoN1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifms.ProjetoN1.model.InfracaoModel;

public interface InfracaoRepository extends JpaRepository<InfracaoModel, Long> {

}
