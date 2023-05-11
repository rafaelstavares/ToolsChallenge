package br.com.ToolsChallenge.transacao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import br.com.ToolsChallenge.descricao.Descricao;
import br.com.ToolsChallenge.formaPagamento.FormaPagamento;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cod_transacao;
	
	@NotBlank
	private String cartao;

	private long id;

	@OneToOne(mappedBy = "transacao", cascade = CascadeType.ALL)
	private Descricao descricao;

	@OneToOne(mappedBy = "transacao", cascade = CascadeType.ALL)
	private FormaPagamento formaPagamento;

	public Transacao() {
//		super();
	}

	public Transacao(long cod_transacao, String cartao, long id, Descricao descricao, FormaPagamento formaPagamento) {
		super();
		this.cod_transacao = cod_transacao;
		this.cartao = cartao;
		this.id = id;
		this.descricao = descricao;
		this.formaPagamento = formaPagamento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCod_transacao() {
		return cod_transacao;
	}

	public void setCod_transacao(long cod_transacao) {
		this.cod_transacao = cod_transacao;
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
