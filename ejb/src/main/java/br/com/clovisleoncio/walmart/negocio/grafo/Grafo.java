package br.com.clovisleoncio.walmart.negocio.grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.clovisleoncio.walmart.negocio.entidade.Mapa;
import br.com.clovisleoncio.walmart.negocio.entidade.Rota;

public class Grafo {
	
	private HashMap<String, Vertice> vertices = new HashMap<String, Vertice>();

	public Grafo(List<Mapa> mapas) {
		for (Mapa mapa : mapas) {
			for (Rota rota : mapa.getRotas()) {
				
				Vertice inicio = safeGet(rota.getOrigem());
				Vertice fim = safeGet(rota.getDestino());
				
				inicio.getArestas().add(new Aresta(fim, rota.getDistancia()));
				
			}
		}
	}

	private Vertice safeGet(String nomeVertice) {
		Vertice vertice = vertices.get(nomeVertice);
		if (vertice == null) {
			vertice = new Vertice(nomeVertice);
			vertices.put(nomeVertice, vertice);
		}
		return vertice;
	}

	public Caminho getMenorCaminho(String origem, String destino) {
		Vertice inicio = vertices.get(origem);
		Vertice fim = vertices.get(destino);
		return getMenorCaminho(inicio, fim);
	}

	public Caminho getMenorCaminho(Vertice inicio, Vertice fim) {
		
		List<Vertice> abertos = new ArrayList<Vertice>(vertices.values());
		
		Map<Vertice, Integer> estimativas = new HashMap<Vertice, Integer>();
		Map<Vertice, Vertice> precedentes = new HashMap<Vertice, Vertice>();
		
		for (Vertice vertice : abertos) {
			estimativas.put(vertice, Integer.MAX_VALUE);
		}
		
		estimativas.put(inicio, 0);
		precedentes.put(inicio, null);
		
		fechar(inicio, estimativas, precedentes);
		abertos.remove(inicio);
		
		while (!abertos.isEmpty()) {
			Vertice menorEstimativa = menorEstimativa(abertos, estimativas);
			fechar(menorEstimativa, estimativas, precedentes);
			abertos.remove(menorEstimativa);
		}
		
		Caminho caminho = new Caminho(estimativas.get(fim));
		
		Vertice precedente = fim;
		do {
			caminho.add(precedente);
			precedente = precedentes.get(precedente);
		} while (precedente != null);
		
		return caminho;
	}
	
	private Vertice menorEstimativa(List<Vertice> abertos, Map<Vertice, Integer> estimativas) {
		int custo = Integer.MAX_VALUE;
		Vertice candidato = null;
		for (Vertice aberto : abertos) {
			int estimativa = estimativas.get(aberto);
			if (estimativa < custo) {
				custo = estimativa;
				candidato = aberto;
			}
		}
		return candidato;
	}

	private void fechar(Vertice vertice, Map<Vertice, Integer> estimativas, Map<Vertice, Vertice> precedentes) {
		int estimativaRaiz = estimativas.get(vertice);
		
		for (Aresta aresta : vertice.getArestas()) {
			Vertice outroVertice = aresta.getDestino();
			int estimativa = estimativaRaiz + aresta.getPeso();
			int estimativaAnterior = estimativas.get(outroVertice);
			
			if (estimativaAnterior > estimativa) {
				estimativas.put(outroVertice, estimativa);
				precedentes.put(outroVertice, vertice);
			}
		}
	}
}
