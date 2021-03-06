package br.com.clovisleoncio.walmart.api;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.clovisleoncio.walmart.api.parse.MalhaLogisticaBuilder;
import br.com.clovisleoncio.walmart.negocio.MalhaLogisticaEJB;
import br.com.clovisleoncio.walmart.negocio.entidade.Mapa;
import br.com.clovisleoncio.walmart.negocio.grafo.Caminho;

@Path("/malhalogistica")
public class MalhaLogisticaService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MalhaLogisticaService.class);
	
	@EJB
	private MalhaLogisticaEJB malhaLogisticaEJB;
	
	@GET
	public String consultar(@QueryParam("origem") String origem, @QueryParam("destino") String destino,
			@QueryParam("autonomia") BigDecimal autonomia, @QueryParam("valorLitro") BigDecimal valorLitro) {
		
		LOGGER.info("Chamada ao serviço consultar.");
		LOGGER.debug(String.format("Origem [%s]", origem));
		LOGGER.debug(String.format("Destino [%s]", destino));
		LOGGER.debug(String.format("Autonomia [%s]", autonomia));
		LOGGER.debug(String.format("Valor Litro [%s]", valorLitro));
		
		Caminho caminho = malhaLogisticaEJB.obterMenorCaminho(origem, destino);

		String resultado = String.format("[%s] custo: %s", caminho.getRota(), caminho.getCusto(autonomia, valorLitro));
		
		LOGGER.debug(String.format("Resultado [%s]", resultado));
		
		return resultado;
	}
	
	@PUT
	public void adicionar(@FormParam("nome") String nome, @FormParam("malha") String malha) {
		LOGGER.info("Chamada ao serviço adicionar.");
		LOGGER.debug(String.format("Nome [%s]", nome));
		LOGGER.debug(String.format("Malha [%s]", malha));

		MalhaLogisticaBuilder builder = new MalhaLogisticaBuilder();
		Mapa mapa = builder.build(nome, malha);
		
		malhaLogisticaEJB.gravar(mapa);
	}

}
