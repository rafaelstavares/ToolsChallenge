package br.com.ToolsChallenge.dto;

public class PagamentoDto {

	TransacaoDTO transacao;

	public PagamentoDto(TransacaoDTO transacao) {
		super();
		this.transacao = transacao;
	}

	public PagamentoDto() {
		super();
	}

	public TransacaoDTO getTransacao() {
		return transacao;
	}

	public void setTransacao(TransacaoDTO transacao) {
		this.transacao = transacao;
	}

}
