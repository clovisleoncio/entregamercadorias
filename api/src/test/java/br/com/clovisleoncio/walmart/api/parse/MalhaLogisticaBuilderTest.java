package br.com.clovisleoncio.walmart.api.parse;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.clovisleoncio.walmart.negocio.entidade.MalhaLogistica;
import br.com.clovisleoncio.walmart.negocio.entidade.Ponto;

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
		
		MalhaLogistica malha = builder.build("Exemplo", exemplo);
		
		assertEquals("Exemplo", malha.getNome());
		
		List<Ponto> pontos = malha.getPontos();
		
		assertEquals(5, pontos.size());
		
		// TODO melhorar testes. Como? Procurar biblioteca mais expressiva
	}

}
