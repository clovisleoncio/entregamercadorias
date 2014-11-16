package br.com.clovisleoncio.walmart.negocio.entidade;

import java.util.ArrayList;
import java.util.List;

public class Ponto {
	
	private String nome;
	private List<Trecho> trechos = new ArrayList<Trecho>(); // set?

	public Ponto(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addTrecho(Ponto destino, Integer distancia) {
		Trecho trecho = new Trecho(this, destino, distancia);
		trechos.add(trecho);
	}

	public List<Trecho> getTrechos() {
		return trechos;
	}

	public void setTrechos(List<Trecho> trechos) {
		this.trechos = trechos;
	}

	public boolean equals(Ponto o) {
		return nome.equals(o.nome);
	}

	public int hashCode() {
		return nome.hashCode();
	}
}
