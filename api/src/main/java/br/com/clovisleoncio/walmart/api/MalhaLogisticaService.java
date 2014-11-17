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
import br.com.clovisleoncio.walmart.negocio.entidade.Caminho;
import br.com.clovisleoncio.walmart.negocio.entidade.MalhaLogistica;

@Path("/malhalogistica")
public class MalhaLogisticaService {
	
	@EJB
	private MalhaLogisticaEJB malhaLogisticaEJB;
	
	@GET
	public String consultar(@QueryParam("nome") String nome, @QueryParam("origem") String origem, @QueryParam("destino") String destino,
			@QueryParam("autonomia") BigDecimal autonomia, @QueryParam("valorLitro") BigDecimal valorLitro) {
		
		MalhaLogistica malha = malhaLogisticaEJB.carregar(nome);
		
		Caminho caminho = malha.getMenorCaminho(origem, destino);

		// TODO onde colocar esse calculo?
		return String.format("[%s] custo: %s", caminho.getRota(), new BigDecimal(caminho.getCusto()).divide(autonomia).multiply(valorLitro));
	}
	
	@PUT
	public String adicionar(@FormParam("nome") String nome, @FormParam("malha") String malha) {
		System.out.println(String.format("Nome da malha: %s", nome));
		System.out.println(String.format("Malha: %s", malha));

		MalhaLogisticaBuilder builder = new MalhaLogisticaBuilder();
		MalhaLogistica malhaLogistica = builder.build(nome, malha);
		
		malhaLogisticaEJB.gravar(malhaLogistica);

		return "Adicionou";
	}

}
