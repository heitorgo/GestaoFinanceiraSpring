package com.gestaofinanceiralog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Clientes {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;
	private String nome_cliente;
	private String dtanasc_cliente;
	private String email_cliente;
	private String cpf_cliente;
	private String cidade_cliente;
	private String rua_cliente;
	private String bairro_cliente;
	private String numcasa_cliente;
	private String telefone_cliente;
	private Long id_empresa;
	
}
