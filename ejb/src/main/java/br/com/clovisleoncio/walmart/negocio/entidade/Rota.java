package br.com.clovisleoncio.walmart.negocio.entidade;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rota {
	
	@Id
	private String id = UUID.randomUUID().toString();

	@Column
	private String origem;

	@Column
	private String destino;
	
	@Column
	private Integer distancia;
	
	public Rota() {
	}
	
	public Rota(String origem, String destino, Integer distancia) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

}
