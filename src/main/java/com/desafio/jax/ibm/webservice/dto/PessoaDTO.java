package com.desafio.jax.ibm.webservice.dto;

import org.modelmapper.ModelMapper;

import com.desafio.jax.ibm.webservice.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PessoaDTO {

	@JsonIgnore
	private Long id;
	private String nome;
	private String endereco;
	private String telefone;
	private String bairro;
	private String cidade;
	private String estado;
	private String cpf;
	
	public Pessoa convertDTOToEntity() {
		return new ModelMapper().map(this, Pessoa.class);
	}
}
