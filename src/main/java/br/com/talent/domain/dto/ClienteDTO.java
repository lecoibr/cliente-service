package br.com.talent.domain.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ClienteDTO {
	
	private Long id;
	private String nome;
	private int idade;
	private String endereco;
	private Date dataNascimento;
	private String cpf;
    private char sexo;

}
