package br.com.aposentadoria.api.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.aposentadoria.models.Contribuicao;

@Path("contribuicoes")
@Produces(MediaType.APPLICATION_JSON)
public class ServicoAposentadoria{
	
	@GET
	@Path("/{x}{y}")
    public List<Contribuicao> getListContribuicao(final @PathParam("x") Double x, final @PathParam("y") Double y){
		return null;
	}

}
