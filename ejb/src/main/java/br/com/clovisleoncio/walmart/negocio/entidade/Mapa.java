package br.com.clovisleoncio.walmart.negocio.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Mapa {
	
	@Id
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "mapa")
	private List<Rota> rotas;
	
	public Mapa() {
	}

	public Mapa(String nome, List<Rota> rotas) {
		this.nome = nome;
		this.rotas = rotas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}

}
