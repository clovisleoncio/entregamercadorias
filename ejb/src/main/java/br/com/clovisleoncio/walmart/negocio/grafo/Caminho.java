package br.com.clovisleoncio.walmart.negocio.grafo;

import java.util.ArrayList;
import java.util.List;

public class Caminho {

	private int custo;
	private List<Vertice> vertices = new ArrayList<Vertice>();

	public Caminho(int custo) {
		this.custo = custo;
	}

	public void add(Vertice vertice) {
		this.vertices.add(0, vertice);
	}

	public int getCusto() {
		return custo;
	}

	public List<Vertice> getVertices() {
		return vertices;
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
