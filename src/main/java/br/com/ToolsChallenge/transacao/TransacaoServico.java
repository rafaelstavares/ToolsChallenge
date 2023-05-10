package br.com.ToolsChallenge.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ToolsChallenge.descricao.Descricao;
import br.com.ToolsChallenge.descricao.DescricaoRepositorio;
import br.com.ToolsChallenge.descricao.DescricaoServico;
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
	
	
	  public void  addTransacao(Transacao temp) {
		 transacao = new Transacao();
//		 descricao = temp.getDescricao();
		 System.out.println(temp.getDescricao().getDataHora());
		 transacao.setCartao(temp.getCartao());
		 transacaoRepositorio.save(transacao);
//		 descricao.setTransacao(transacao);
//		 descricao.setDataHora(temp.getDescricao().getDataHora());
//		 descricao.setEstabelecimento(temp.getDescricao().getEstabelecimento());
//		 descricao.setValor(temp.getDescricao().getValor());
		 descricaoServico.addDescricao(temp.getDescricao(),transacao);
		 formaPagamentoServico.addFormaPagamento(temp.getFormaPagamento(), transacao);
	 }


	public Transacao findId(long id) {
		
		return transacaoRepositorio.getById(id);
	};
	 
}
