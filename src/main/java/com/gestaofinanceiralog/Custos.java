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
public class Custos {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDCUSTO;
	private Float VALORCUSTO;
	private String DATACUSTO;
	private String DETALHAMENTOCUSTO;
	private Boolean VERIFCUSTO;
	private Long IDEMPRESA;

}
