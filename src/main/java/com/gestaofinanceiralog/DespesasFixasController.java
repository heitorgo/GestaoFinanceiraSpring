package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/despesasfixas")
public class DespesasFixasController {

	private DespesasFixasRepository despesasfixasRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE DESPESAS FIXAS
	@GetMapping
	public List<DespesasFixas> listardespesasfixas(){
		
		return despesasfixasRepository.findAll();
		
	}
	
}
