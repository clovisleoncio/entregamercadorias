package br.com.clovisleoncio.walmart.api;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import br.com.clovisleoncio.walmart.api.parse.MalhaLogisticaBuilder;
import br.com.clovisleoncio.walmart.negocio.MalhaLogisticaEJB;
import br.com.clovisleoncio.walmart.negocio.entidade.Mapa;
import br.com.clovisleoncio.walmart.negocio.grafo.Caminho;

@Path("/malhalogistica")
public class MalhaLogisticaService {
	
	@EJB
	private MalhaLogisticaEJB malhaLogisticaEJB;
	
	@GET
	public String consultar(@QueryParam("origem") String origem, @QueryParam("destino") String destino,
			@QueryParam("autonomia") BigDecimal autonomia, @QueryParam("valorLitro") BigDecimal valorLitro) {
		
		Caminho caminho = malhaLogisticaEJB.obterMenorCaminho(origem, destino);

		return String.format("[%s] custo: %s", caminho.getRota(), caminho.getCusto(autonomia, valorLitro));
	}
	
	@PUT
	public void adicionar(@FormParam("nome") String nome, @FormParam("malha") String malha) {
		System.out.println(String.format("Nome do mapa: %s", nome));
		System.out.println(String.format("Malha: %s", malha));

		MalhaLogisticaBuilder builder = new MalhaLogisticaBuilder();
		Mapa mapa = builder.build(nome, malha);
		
		malhaLogisticaEJB.gravar(mapa);
	}

}
