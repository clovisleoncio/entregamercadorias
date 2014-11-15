package br.com.clovisleoncio.walmart.negocio.entidade;

public class Trecho {

	private Ponto origem;
	private Ponto destino;
	private Integer distancia;

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
