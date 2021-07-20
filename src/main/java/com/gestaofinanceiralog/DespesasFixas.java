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
	private Long id_despesa_fixa;
	private Float valor_despesa_fixa;
	private String frequencia_despesa;
	private String detalhamento_despesa_fixa;
	private Boolean verif_despesa_fixa;
	private Long id_empresa;

}
