package br.com.ToolsChallenge.transacao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.ToolsChallenge.descricao.Descricao;
import br.com.ToolsChallenge.formaPagamento.FormaPagamento;

@Entity
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String cartao;
	
	@OneToOne(mappedBy = "transacao" , cascade = CascadeType.ALL)
	private Descricao descricao;
	
	@OneToOne(mappedBy = "transacao" , cascade = CascadeType.ALL)
	private FormaPagamento formaPagamento;

	public Transacao() {
//		super();
	}

	public Transacao(long id, String cartao , Descricao descricao, FormaPagamento formaPagamento) {
		this.id = id;
		this.cartao = cartao;
		this.descricao = descricao;
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

	public Descricao getDescricao() {
		return descricao;
	}

	public void setDescricao(Descricao descricao) {
		this.descricao = descricao;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
}
