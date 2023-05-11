package br.com.ToolsChallenge.util;

public enum Status {

	AUTORIZADO("AUTORIZADO"), NEGADO("NEGADO"), CANCELADO("CANCELADO");
	
	private final String nome;
	
	Status(String nome){
		this.nome = nome;
		}
	
	public String getNome(){
		return nome;
		}
}
