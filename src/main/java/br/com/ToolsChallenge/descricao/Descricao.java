package br.com.ToolsChallenge.descricao;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ToolsChallenge.formaPagamento.FormaPagamento;
import br.com.ToolsChallenge.transacao.Transacao;

@Entity
public class Descricao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private BigDecimal valor;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", locale = "pt_br")
	private Date dataHora;

	private String estabelecimento;

	@OneToOne
	Transacao transacao;

	public Descricao() {
	}

	public Descricao(Long id, BigDecimal valor, Date dataHora, String estabelecimento, Transacao transacao) {
		this.id = id;
		this.valor = valor;
		this.dataHora = dataHora;
		this.estabelecimento = estabelecimento;
		this.transacao = transacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

}
