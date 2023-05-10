package br.com.ToolsChallenge.descricao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ToolsChallenge.formaPagamento.FormaPagamentoServico;
import br.com.ToolsChallenge.transacao.Transacao;

@Service
public class DescricaoServico {

	@Autowired
	DescricaoRepositorio descricaoRepositorio;
	
	Descricao descricao;
	
	public void addDescricao(Descricao t, Transacao temp) {
		descricao = t;
		descricao.setDataHora(t.getDataHora());
		descricao.setEstabelecimento(t.getEstabelecimento());
		descricao.setValor(t.getValor());
		descricao.setTransacao(temp);
		descricaoRepositorio.save(descricao);
		
	}
}
