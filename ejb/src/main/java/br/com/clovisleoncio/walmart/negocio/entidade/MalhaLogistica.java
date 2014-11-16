package br.com.clovisleoncio.walmart.negocio.entidade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MalhaLogistica {
	
	private String nome;
	private List<Ponto> pontos;
	
	public MalhaLogistica(String nome, List<Ponto> pontos) {
		this.nome = nome;
		this.pontos = pontos;
	}
	
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

	public Caminho getMenorCaminho(Ponto inicio, Ponto fim) {
		
		List<Ponto> abertos = new ArrayList<Ponto>(pontos);
		
		Map<Ponto, Integer> estimativas = new HashMap<Ponto, Integer>();
		Map<Ponto, Ponto> precedentes = new HashMap<Ponto, Ponto>();
		
		for (Ponto ponto : pontos) {
			estimativas.put(ponto, Integer.MAX_VALUE);
		}
		
		estimativas.put(inicio, 0);
		precedentes.put(inicio, null);
		
		fechar(inicio, estimativas, precedentes);
		abertos.remove(inicio);
		
		while (!abertos.isEmpty()) {
			Ponto menorEstimativa = menorEstimativa(abertos, estimativas);
			fechar(menorEstimativa, estimativas, precedentes);
			abertos.remove(menorEstimativa);
		}
		
		Caminho caminho = new Caminho(estimativas.get(fim));
		
		Ponto precedente = fim;
		do {
			caminho.add(precedente);
			precedente = precedentes.get(precedente);
		} while (precedente != null);
		
		return caminho;
	}
	
	private Ponto menorEstimativa(List<Ponto> abertos, Map<Ponto, Integer> estimativas) {
		int custo = Integer.MAX_VALUE;
		Ponto candidato = null;
		for (Ponto aberto : abertos) {
			int estimativa = estimativas.get(aberto);
			if (estimativa < custo) {
				custo = estimativa;
				candidato = aberto;
			}
		}
		return candidato;
	}

	private void fechar(Ponto ponto, Map<Ponto, Integer> estimativas, Map<Ponto, Ponto> precedentes) {
		Integer estimativaRaiz = estimativas.get(ponto);
		
		for (Trecho trecho : ponto.getTrechos()) {
			Ponto outroPonto = trecho.getDestino();
			int estimativa = estimativaRaiz + trecho.getDistancia();
			int estimativaAnterior = estimativas.get(outroPonto);
			
			if (estimativaAnterior > estimativa) {
				estimativas.put(outroPonto, estimativa);
				precedentes.put(outroPonto, ponto);
			}
		}
	}


}
