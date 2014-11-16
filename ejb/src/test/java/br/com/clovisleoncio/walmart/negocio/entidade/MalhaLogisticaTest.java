package br.com.clovisleoncio.walmart.negocio.entidade;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MalhaLogisticaTest {
	
	@Test
	public void deveEncontrarMenorCaminhoDoisPontos() {
		
		Ponto a = new Ponto("A");
		Ponto b = new Ponto("B");
		
		a.addTrecho(b, 10);
		
		MalhaLogistica malha = new MalhaLogistica("Teste 1", Arrays.asList(new Ponto[]{a, b}));
		
		Caminho caminho = malha.getMenorCaminho(a, b);
		
		List<Ponto> pontos = caminho.getPontos();
		
		assertEquals(10, caminho.getCusto());
		assertEquals(2, pontos.size());
		assertEquals(a, pontos.get(0));
		assertEquals(b, pontos.get(1));
	}
	
	@Test
	public void deveEncontrarSolucaoExemplo() {
		
		Ponto a = new Ponto("A");
		Ponto b = new Ponto("B");
		Ponto c = new Ponto("C");
		Ponto d = new Ponto("D");
		Ponto e = new Ponto("E");
		
		a.addTrecho(b, 10);
		b.addTrecho(d, 15);
		a.addTrecho(c, 20);
		c.addTrecho(d, 30);
		b.addTrecho(e, 50);
		d.addTrecho(e, 30);
		
		MalhaLogistica grafo = new MalhaLogistica("Exemplo", Arrays.asList(new Ponto[]{a, b, c, d, e}));
		
		Caminho caminho = grafo.getMenorCaminho(a, d);
		
		List<Ponto> Pontos = caminho.getPontos();
		
		assertEquals(25, caminho.getCusto());
		assertEquals(3, Pontos.size());
		assertEquals(a, Pontos.get(0));
		assertEquals(b, Pontos.get(1));
		assertEquals(d, Pontos.get(2));

	}

}
