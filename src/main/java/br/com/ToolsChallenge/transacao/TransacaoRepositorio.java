package br.com.ToolsChallenge.transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepositorio  extends JpaRepository<Transacao, Long>  {

	Transacao save(Transacao t);
	
}
