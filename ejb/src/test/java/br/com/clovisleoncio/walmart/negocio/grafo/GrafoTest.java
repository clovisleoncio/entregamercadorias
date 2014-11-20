package br.com.clovisleoncio.walmart.negocio.grafo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.clovisleoncio.walmart.negocio.entidade.Mapa;
import br.com.clovisleoncio.walmart.negocio.entidade.Rota;

public class GrafoTest {
	
	@Test
	public void deveEncontrarMenorCaminhoDoisPontos() {
		
		Mapa mapa = new Mapa("Teste 1", Arrays.asList(new Rota[]{
				new Rota("A", "B", 10)
		}));
		
		Grafo grafo = new Grafo(Arrays.asList(new Mapa[]{mapa}));

		Caminho caminho = grafo.getMenorCaminho("A", "B");
		
		List<Vertice> vertices = caminho.getVertices();
		
		assertEquals(10, caminho.getPeso());
		assertEquals(2, vertices.size());
		assertEquals("A", vertices.get(0).getNome());
		assertEquals("B", vertices.get(1).getNome());
	}
	
	@Test
	public void deveEncontrarSolucaoExemplo() {
		
		Mapa mapa = new Mapa("Teste 1", Arrays.asList(new Rota[]{
				new Rota("A", "B", 10),
				new Rota("B", "D", 15),
				new Rota("A", "C", 20),
				new Rota("C", "D", 30),
				new Rota("B", "E", 50),
				new Rota("D", "E", 30)
		}));
		
		Grafo grafo = new Grafo(Arrays.asList(new Mapa[]{mapa}));
		
		Caminho caminho = grafo.getMenorCaminho("A", "D");
		
		List<Vertice> vertices = caminho.getVertices();
		
		assertEquals(25, caminho.getPeso());
		assertEquals(3, vertices.size());
		assertEquals("A", vertices.get(0).getNome());
		assertEquals("B", vertices.get(1).getNome());
		assertEquals("D", vertices.get(2).getNome());

	}
	
	@Test
	public void devePermitirDoisMapasGrafo() {
		
		Mapa mapa1 = new Mapa("Teste 1", Arrays.asList(new Rota[]{
				new Rota("A", "B", 10),
				new Rota("A", "C", 20),
				new Rota("C", "D", 30),
		}));
		
		Mapa mapa2 = new Mapa("Teste 2", Arrays.asList(new Rota[]{
				new Rota("B", "D", 15),
				new Rota("B", "E", 50),
				new Rota("D", "E", 30)
		}));
		
		Grafo grafo = new Grafo(Arrays.asList(new Mapa[]{mapa1, mapa2}));
		
		Caminho caminho = grafo.getMenorCaminho("A", "D");
		
		List<Vertice> vertices = caminho.getVertices();
		
		assertEquals(25, caminho.getPeso());
		assertEquals(3, vertices.size());
		assertEquals("A", vertices.get(0).getNome());
		assertEquals("B", vertices.get(1).getNome());
		assertEquals("D", vertices.get(2).getNome());

	}

}
