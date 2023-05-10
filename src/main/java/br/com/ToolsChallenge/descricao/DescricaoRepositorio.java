package br.com.ToolsChallenge.descricao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescricaoRepositorio  extends JpaRepository<Descricao, Long>  {

	Descricao save(Descricao t);
	
}