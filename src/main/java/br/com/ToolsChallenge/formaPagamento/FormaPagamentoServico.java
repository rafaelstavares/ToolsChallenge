package br.com.ToolsChallenge.formaPagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ToolsChallenge.transacao.Transacao;

@Service
public class FormaPagamentoServico {

	@Autowired
	FormaPagamentoRepositorio formaPagamentoRepositorio;
	
	FormaPagamento formaPagamento;
	
	public void addFormaPagamento(FormaPagamento f,Transacao t) {
		formaPagamento = f;
		formaPagamento.setTransacao(t);
		formaPagamentoRepositorio.save(formaPagamento);
	}
}
