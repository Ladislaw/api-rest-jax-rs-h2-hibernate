package com.desafio.jax.ibm.webservice.resources;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import com.desafio.jax.ibm.webservice.dto.PessoaDTO;

public class PessoaResourceTest {

	private PessoaResource resource = new PessoaResource();
	
	@Test
	public void inserirPessoa_teste() {
		
		final Response response = Response.status(Status.CREATED).build();
		
		assertEquals(response.getStatus(), resource.save(getPessoaDtoFactory()).getStatus());
	}
	
	private PessoaDTO getPessoaDtoFactory() {
		PessoaDTO dto = new PessoaDTO();
		dto.setNome("Pessoa Teste");
		dto.setCpf("123456789");
		dto.setEndereco("Rua teste");
		dto.setTelefone("888888888");
		dto.setEstado("BA");
		dto.setCidade("Salvador");
		dto.setBairro("Brotas");
		return dto;
	}
}
