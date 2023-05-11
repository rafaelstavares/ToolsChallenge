package br.com.ToolsChallenge.dto;

import javax.validation.constraints.NotEmpty;

import br.com.ToolsChallenge.transacao.Transacao;

public class TransacaoDTO {

	private long id;

	@NotEmpty
	private String cartao;

	private DescricaoDto descricao;

	private FormaPagamentoDto formaPagamento;

	public TransacaoDTO(long id, String cartao, DescricaoDto descricao, FormaPagamentoDto formaPagamento) {
		super();
		this.id = id;
		this.cartao = cartao;
		this.descricao = descricao;
		this.formaPagamento = formaPagamento;
	}

	public TransacaoDTO() {
		super();
	}

	public TransacaoDTO(Transacao transacao) {
		this.id = transacao.getId();
		this.cartao = transacao.getCartao();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public DescricaoDto getDescricao() {
		return descricao;
	}

	public void setDescricao(DescricaoDto descricaoDto) {
		this.descricao = descricaoDto;
	}

	public FormaPagamentoDto getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoDto formaPagamentoDto) {
		this.formaPagamento = formaPagamentoDto;
	}

}
