package br.com.clovisleoncio.walmart.negocio.entidade;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trecho {
	
	@Id
	private String id = UUID.randomUUID().toString();

	@ManyToOne
	@JoinColumn(name = "origem")
	private Ponto origem;

	@ManyToOne
	@JoinColumn(name = "destino")
	private Ponto destino;
	
	// Trocar distancia para bigdecimal
	@Column
	private Integer distancia;
	
	public Trecho() {
	}

	public Trecho(Ponto origem, Ponto destino, Integer distancia) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}

	public Ponto getOrigem() {
		return origem;
	}

	public void setOrigem(Ponto origem) {
		this.origem = origem;
	}

	public Ponto getDestino() {
		return destino;
	}

	public void setDestino(Ponto destino) {
		this.destino = destino;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

}
