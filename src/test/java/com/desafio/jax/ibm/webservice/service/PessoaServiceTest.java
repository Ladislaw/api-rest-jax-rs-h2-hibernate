package com.desafio.jax.ibm.webservice.service;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import com.desafio.jax.ibm.webservice.dto.PessoaDTO;

public class PessoaServiceTest {
	
	private PessoaService service = new PessoaService();
	
	@Test
	public void buscarPessoaPorCPF_test() {
		
		PessoaDTO dto = getPessoaDtoFactory();
		
		service.savePessoa(dto);
		
		assertEquals(dto.getCpf(), service.findByCpfOrName(dto.getCpf()).getCpf());
	}

	@Test
	public void buscarPessoaPorNome_test() {
		
		PessoaDTO dto = getPessoaDtoFactory();
		
		service.savePessoa(dto);
		
		assertEquals(dto.getNome(), service.findByCpfOrName(dto.getNome()).getNome());
	}
	
	private PessoaDTO getPessoaDtoFactory() {
		Integer random = new Random().nextInt(999);
		PessoaDTO dto = new PessoaDTO();
		dto.setNome("Pessoa"+random);
		dto.setCpf(random.toString());
		dto.setEndereco("Rua teste");
		dto.setTelefone("888888888");
		dto.setEstado("BA");
		dto.setCidade("Salvador");
		dto.setBairro("Brotas");
		return dto;
	}
}
