package br.com.ToolsChallenge.formaPagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepositorio extends JpaRepository<FormaPagamento, Long>  {

	FormaPagamento save(FormaPagamento f);

}
