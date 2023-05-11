package br.com.ToolsChallenge.dto;

import br.com.ToolsChallenge.transacao.Transacao;

public class TransacaoDTO {

	private long id;
	
	private String cartao;
	
	private DescricaoDto descricaoDto;
	
	private FormaPagamentoDto formaPagamentoDto;
	
	
	public TransacaoDTO(long id, String cartao, DescricaoDto descricaoDto, FormaPagamentoDto formaPagamentoDto) {
		super();
		this.id = id;
		this.cartao = cartao;
		this.descricaoDto = descricaoDto;
		this.formaPagamentoDto = formaPagamentoDto;
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
		return descricaoDto;
	}

	public void setDescricaoDto(DescricaoDto descricaoDto) {
		this.descricaoDto = descricaoDto;
	}

	public FormaPagamentoDto getFormaPagamentoDto() {
		return formaPagamentoDto;
	}

	public void setFormaPagamentoDto(FormaPagamentoDto formaPagamentoDto) {
		this.formaPagamentoDto = formaPagamentoDto;
	}
	
	
}
