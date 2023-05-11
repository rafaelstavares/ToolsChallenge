package br.com.ToolsChallenge.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ToolsChallenge.descricao.Descricao;
import br.com.ToolsChallenge.descricao.DescricaoServico;
import br.com.ToolsChallenge.formaPagamento.FormaPagamento;
import br.com.ToolsChallenge.formaPagamento.FormaPagamentoServico;

@Service
public class TransacaoServico {

	@Autowired
	TransacaoRepositorio transacaoRepositorio;

	@Autowired
	DescricaoServico descricaoServico;

	@Autowired
	FormaPagamentoServico formaPagamentoServico;

	Transacao transacao;

	Descricao descricao;

	FormaPagamento formaPagamento;

	public Transacao addTransacao(Transacao temp) {
		transacao = new Transacao();
		transacao.setCartao(temp.getCartao());
		transacao.setId(temp.getId());
		transacao = transacaoRepositorio.save(transacao);
		descricao = descricaoServico.addDescricao(temp.getDescricao(), transacao);
		formaPagamento = formaPagamentoServico.addFormaPagamento(temp.getFormaPagamento(), transacao);
		transacao.setDescricao(descricao);
		transacao.setFormaPagamento(formaPagamento);
		return transacao;
	}

	public Transacao findId(long id) {

		return transacaoRepositorio.getById(id);
	};

}
