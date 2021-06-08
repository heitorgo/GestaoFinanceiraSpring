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
public class CustosFixos {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDCUSTOFIXO;
	private Float VALORCUSTOFIXO;
	private String FREQUENCIACUSTO;
	private String DETALHAMENTOCUSTOFIXO;
	private Boolean VERIFCUSTOFIXO;
	private Long IDEMPRESA;

}
