package br.com.ToolsChallenge.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ToolsChallenge.util.Status;

public class DescricaoDto {

	private BigDecimal valor;

	private Date dataHora;

	private String estabelecimento;

	private Long nsu;

	private Long codigoAutorizacao;

	private String status;

	public DescricaoDto() {
		super();
	}

	public DescricaoDto(BigDecimal valor, Date dataHora, String estabelecimento, Long nsu, Long codigoAutorizacao,
			String status) {
		super();
		this.valor = valor;
		this.dataHora = dataHora;
		this.estabelecimento = estabelecimento;
		this.nsu = nsu;
		this.codigoAutorizacao = codigoAutorizacao;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
