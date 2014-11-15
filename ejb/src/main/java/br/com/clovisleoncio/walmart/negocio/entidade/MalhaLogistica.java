package br.com.clovisleoncio.walmart.negocio.entidade;

import java.util.List;

public class MalhaLogistica {
	
	private String nome;
	private List<Ponto> pontos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Ponto> getPontos() {
		return pontos;
	}
	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}

}
