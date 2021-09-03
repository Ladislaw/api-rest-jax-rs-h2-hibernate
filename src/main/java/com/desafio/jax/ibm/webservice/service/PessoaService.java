package com.desafio.jax.ibm.webservice.service;

import java.util.Optional;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.desafio.jax.ibm.webservice.dao.PessoaDAO;
import com.desafio.jax.ibm.webservice.model.Pessoa;

public class PessoaService {

	PessoaDAO dao = new PessoaDAO();
	
	public Pessoa savePessoa(Pessoa pessoa) {
		
		if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
			throw new ClientErrorException(Response.status(Status.BAD_REQUEST).entity("Nome n�o informado!").build());
		}

		if (pessoa.getCpf() == null || pessoa.getCpf().isEmpty()) {
			throw new ClientErrorException(Response.status(Status.BAD_REQUEST).entity("CPF n�o informado!").build());
		}
		
		return dao.save(pessoa);
	}
	
	public Optional<Pessoa> findByCpfOrName(String search){
		return dao.findByCpfOrName(search);
	}
}
