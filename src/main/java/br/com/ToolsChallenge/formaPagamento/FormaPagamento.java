package br.com.ToolsChallenge.formaPagamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.ToolsChallenge.transacao.Transacao;

@Entity
public class FormaPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String tipo;
	
	private int parcelas;
	
	@OneToOne
	private Transacao transacao;
	
	public FormaPagamento() {

	}

	public FormaPagamento(Long id,String tipo, int parcelas, Transacao transacao) {
		this.id = id;
		this.tipo = tipo;
		this.parcelas = parcelas;
		this.transacao = transacao;
	
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
	
	
	
}
