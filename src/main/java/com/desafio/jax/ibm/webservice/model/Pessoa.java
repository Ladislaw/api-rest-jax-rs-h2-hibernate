package com.desafio.jax.ibm.webservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.desafio.jax.ibm.webservice.dto.PessoaDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	private String endereco;
	private String telefone;
	private String bairro;
	private String cidade;
	private String estado;
	
	@NotNull
	private String cpf;
	
	public PessoaDTO convertEntityToDTO() {
		return new ModelMapper().map(this, PessoaDTO.class);
	}
}
