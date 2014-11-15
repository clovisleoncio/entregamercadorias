package br.com.clovisleoncio.walmart.api.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.clovisleoncio.walmart.negocio.entidade.MalhaLogistica;
import br.com.clovisleoncio.walmart.negocio.entidade.Ponto;

public class MalhaLogisticaBuilder {
	
	private Map<String, Ponto> nomesToPontos = new HashMap<String, Ponto>();
	
	public MalhaLogistica build(String nome, String representacao) {
		
		MalhaLogistica malha = new MalhaLogistica();
		malha.setNome(nome);
		
		String[] linhas = representacao.split("\n");
		
		for (String linha : linhas) {
			
			String[] dadosLinha = linha.split("\\s+");
			
			String nomeOrigem = dadosLinha[0];
			String nomeDestino = dadosLinha[1];
			Integer distancia = Integer.valueOf(dadosLinha[2]);
			
			Ponto origem = getPonto(nomeOrigem);
			Ponto destino = getPonto(nomeDestino);
			
			origem.addTrecho(destino, distancia);
			
		}
		
		malha.setPontos(new ArrayList<Ponto>(nomesToPontos.values()));
		
		return malha;
	}

	private Ponto getPonto(String nome) {
		Ponto ponto = nomesToPontos.get(nome);
		if (ponto == null) {
			ponto = new Ponto(nome);
			nomesToPontos.put(nome, ponto);
		}
		return ponto;
	}

}
