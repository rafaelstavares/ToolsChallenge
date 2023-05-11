package br.com.ToolsChallenge.dto;

public class FormaPagamentoDto {

	private String tipo;
	
	private int parcelas;

	public FormaPagamentoDto() {
		super();
	}

	public FormaPagamentoDto(String tipo, int parcelas) {
		super();
		this.tipo = tipo;
		this.parcelas = parcelas;
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
	
	
}
