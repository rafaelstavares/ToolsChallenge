package br.com.ToolsChallenge.dto;

public class TransacaoDTO {

	private long id;
	
	private String cartao;

	public TransacaoDTO(long id, String cartao) {
		super();
		this.id = id;
		this.cartao = cartao;
	}

	public TransacaoDTO() {
		super();
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
	
	
}
