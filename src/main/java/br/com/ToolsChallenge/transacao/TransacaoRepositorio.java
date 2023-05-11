package br.com.ToolsChallenge.transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepositorio  extends JpaRepository<Transacao, Long>  {

	Transacao save(Transacao t);
	
	@Query("SELECT t FROM Transacao t WHERE t.id = ?1")
	<optional>Transacao buscarPorId(Long l);
	
}
