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
public class ContasPagar {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDPAGAR;
	private Float VALORPAGAR;
	private String DATAPAGAR;
	private String DETALHAMENTOPAGAR;
	private Boolean VERIFPAGAR;
	private Long IDEMPRESA;
	
}
