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
public class Empresas {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDEMPRESA;
	private String NOMEEMPRESA;
	private String EMAILEMPRESA;
	private String CONTATOEMPRESA;
	private String CIDADEEMPRESA;
	private String RUAEMPRESA;
	private String NUMEMPRESA;
	
}
