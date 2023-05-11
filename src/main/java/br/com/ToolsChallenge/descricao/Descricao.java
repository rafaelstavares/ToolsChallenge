package br.com.ToolsChallenge.descricao;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ToolsChallenge.transacao.Transacao;
import br.com.ToolsChallenge.util.Status;

@Entity
public class Descricao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private BigDecimal valor;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", locale = "pt_br")
	private Date dataHora;

	private String estabelecimento;

	private Long nsu;

	private Long codigoAutorizacao;

	private Status status;

	@OneToOne
	Transacao transacao;

	public Descricao(Long i, BigDecimal j, String s, Long k, Long l, Status autorizado, Object object) {
		this.id = i;
		this.valor = j;
		this.estabelecimento = s;
		this.nsu = k;
		this.codigoAutorizacao = l;
		this.status = autorizado;
		this.transacao = (Transacao) object;
	}

	public Descricao(Long id, BigDecimal valor, Date dataHora, String estabelecimento, Long nsu, Long codigoAutorizacao,
			Status status, Transacao transacao) {
		super();
		this.id = id;
		this.valor = valor;
		this.dataHora = dataHora;
		this.estabelecimento = estabelecimento;
		this.nsu = nsu;
		this.codigoAutorizacao = codigoAutorizacao;
		this.status = status;
		this.transacao = transacao;
	}

	public Long getNsu() {
		return nsu;
	}

	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}

	public Long getCodigoAutorizacao() {
		return codigoAutorizacao;
	}

	public void setCodigoAutorizacao(Long codigoAutorizacao) {
		this.codigoAutorizacao = codigoAutorizacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
