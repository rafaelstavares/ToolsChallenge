package br.com.ToolsChallenge.util;

public enum Tipo {

	AVISTA("AVISTA"), PARCELADO_LOJA("PARCELADO LOJA"), PARCELADO_EMISSOR("PARCELADO EMISSOR");
private final String nome;
	
	Tipo(String nome){
		this.nome = nome;
		}
	
	public String getNome(){
		return nome;
		}
}
