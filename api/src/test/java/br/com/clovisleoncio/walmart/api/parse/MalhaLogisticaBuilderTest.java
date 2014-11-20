package br.com.clovisleoncio.walmart.api.parse;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.clovisleoncio.walmart.negocio.entidade.Mapa;
import br.com.clovisleoncio.walmart.negocio.entidade.Rota;

public class MalhaLogisticaBuilderTest {
	
	@Test
	public void deveConverterExemplo() {
		
		MalhaLogisticaBuilder builder = new MalhaLogisticaBuilder();
		
		String exemplo = "A B 10\n"
				+ "B D 15\n"
				+ "A C 20\n"
				+ "C D 30\n"
				+ "B E 50\n"
				+ "D E 30";
		
		Mapa mapa = builder.build("Exemplo", exemplo);
		
		assertEquals("Exemplo", mapa.getNome());
		
		List<Rota> pontos = mapa.getRotas();
		
		assertEquals(6, pontos.size());
		
		// TODO melhorar testes. Como? Procurar biblioteca mais expressiva
	}

}
