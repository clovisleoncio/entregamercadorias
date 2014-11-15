package br.com.clovisleoncio.walmart.service;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/malhalogistica")
public class MalhaLogisticaService {
	
	@GET
	public String consultar(@QueryParam("nome") String nome, @QueryParam("origem") String origem, @QueryParam("destino") String destino,
			@QueryParam("autonomia") Integer autonomia, @QueryParam("valorLitro") BigDecimal valorLitro) {
		
		System.out.println(String.format("nome da malha: %s", nome));
		System.out.println(String.format("Origem: %s", origem));
		System.out.println(String.format("Destino: %s", destino));
		System.out.println(String.format("Autonomia: %s", autonomia));
		System.out.println(String.format("Valor do Litro: %s", valorLitro));

		return "Chegou";
	}

}
