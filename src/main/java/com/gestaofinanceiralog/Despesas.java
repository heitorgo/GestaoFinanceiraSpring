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
public class Despesas {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDDESPESA;
	private Float VALORDESPESA;
	private String DATADESPESA;
	private String DETALHAMENTODESPESA;
	private Boolean VERIFDESPESA;
	private Long IDEMPRESA;

}
