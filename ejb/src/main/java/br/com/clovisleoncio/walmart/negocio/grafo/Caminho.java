package br.com.clovisleoncio.walmart.negocio.grafo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Caminho {

	private int peso;
	private List<Vertice> vertices = new ArrayList<Vertice>();

	public Caminho(int peso) {
		this.peso = peso;
	}

	public void add(Vertice vertice) {
		this.vertices.add(0, vertice);
	}

	public int getPeso() {
		return peso;
	}

	public List<Vertice> getVertices() {
		return vertices;
	}
	
	public BigDecimal getCusto(BigDecimal autonomia, BigDecimal valorLitro) {
		return new BigDecimal(peso).divide(autonomia).multiply(valorLitro);
	}

	public String getRota() {
		StringBuilder rota = new StringBuilder();
		
		String separador = "";
		for (Vertice vertice : vertices) {
			rota.append(separador);
			rota.append(vertice.getNome());
			separador = ",";
		}
		
		return rota.toString();
	}


}
