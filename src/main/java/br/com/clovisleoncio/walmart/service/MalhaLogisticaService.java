package br.com.clovisleoncio.walmart.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/malhalogistica")
public class MalhaLogisticaService {
	
	@GET
	public String adicionar() {
		return "Chegou";
	}

}
