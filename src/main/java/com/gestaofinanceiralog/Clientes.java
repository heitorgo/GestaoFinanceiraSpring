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
	private Long IDCLIENTE;
	private String NOMECLIENTE;
	private String DTANASCCLIENTE;
	private String EMAILCLIENTE;
	private String CPFCLIENTE;
	private String CIDADECLIENTE;
	private String RUACLIENTE;
	private String BAIRROCLIENTE;
	private String NUMCASACLIENTE;
	private String CONTATOCLIENTE;
	private String COMPLCLIENTE;
	private Long IDEMPRESA;
	
}
