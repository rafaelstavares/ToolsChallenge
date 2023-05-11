package br.com.ToolsChallenge.dto;

import br.com.ToolsChallenge.transacao.Transacao;

public class TransacaoDTO {

	private long id;
	
	private String cartao;
	
	private DescricaoDto descricao;
	
	private FormaPagamentoDto formaPagamento;
	
	
	public TransacaoDTO(long id, String cartao, DescricaoDto descricaoDto, FormaPagamentoDto formaPagamentoDto) {
		super();
		this.id = id;
		this.cartao = cartao;
		this.descricao = descricaoDto;
		this.formaPagamento = formaPagamentoDto;
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

	public DescricaoDto getDescricaoDto() {
		return descricao;
	}

	public void setDescricaoDto(DescricaoDto descricaoDto) {
		this.descricao = descricaoDto;
	}

	public FormaPagamentoDto getFormaPagamentoDto() {
		return formaPagamento;
	}

	public void setFormaPagamentoDto(FormaPagamentoDto formaPagamentoDto) {
		this.formaPagamento = formaPagamentoDto;
	}
	
	
}
