package com.desafio.jax.ibm.webservice.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.desafio.jax.ibm.webservice.model.Pessoa;
import com.desafio.jax.ibm.webservice.service.PessoaService;

@Path("/pessoas")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class PessoaResource {

	private PessoaService service = new PessoaService();
	
	@POST
	public Response save(Pessoa pessoa) {
		pessoa = service.savePessoa(pessoa);
		return Response.status(Status.CREATED)
				.entity(pessoa)
				.build();
	}
	
	@GET
	@Path("{search}")
	public Response find(@PathParam("search") String search) {
		return service.findByCpfOrName(search)
				.map(achou -> Response.ok(achou).build())
				.orElse(Response.noContent().build());
	}
}
