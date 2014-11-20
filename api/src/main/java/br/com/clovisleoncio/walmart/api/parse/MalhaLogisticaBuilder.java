package br.com.clovisleoncio.walmart.api.parse;

import java.util.ArrayList;
import java.util.List;

import br.com.clovisleoncio.walmart.negocio.entidade.Mapa;
import br.com.clovisleoncio.walmart.negocio.entidade.Rota;

public class MalhaLogisticaBuilder {
	
	public Mapa build(String nome, String representacao) {
		
		String[] linhas = representacao.split("\n");
		
		List<Rota> rotas = new ArrayList<Rota>();
		
		for (String linha : linhas) {
			
			String[] dadosLinha = linha.split("\\s+");
			
			String nomeOrigem = dadosLinha[0];
			String nomeDestino = dadosLinha[1];
			Integer distancia = Integer.valueOf(dadosLinha[2]);
			
			rotas.add(new Rota(nomeOrigem, nomeDestino, distancia));
			
		}
		
		return new Mapa(nome, rotas);
	}

}
