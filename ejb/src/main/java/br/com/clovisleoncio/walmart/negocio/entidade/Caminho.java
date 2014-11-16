package br.com.clovisleoncio.walmart.negocio.entidade;

import java.util.ArrayList;
import java.util.List;

public class Caminho {

	private int custo;
	private List<Ponto> pontos = new ArrayList<Ponto>();

	public Caminho(int custo) {
		this.custo = custo;
	}

	public void add(Ponto ponto) {
		this.pontos.add(0, ponto);
	}

	public int getCusto() {
		return custo;
	}

	public List<Ponto> getPontos() {
		return pontos;
	}

	public String getRota() {
		StringBuilder rota = new StringBuilder();
		
		String separador = "";
		for (Ponto ponto : pontos) {
			rota.append(separador);
			rota.append(ponto.getNome());
			separador = ",";
		}
		
		return rota.toString();
	}

}
