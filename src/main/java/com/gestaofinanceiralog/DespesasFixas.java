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
public class DespesasFixas {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDDESPESAFIXA;
	private Float VALORDESPESAFIXA;
	private String FREQUENCIADESPESA;
	private String DETALHAMENTODESPESAFIXA;
	private Boolean VERIFDESPESAFIXA;
	private Long IDEMPRESA;

}
