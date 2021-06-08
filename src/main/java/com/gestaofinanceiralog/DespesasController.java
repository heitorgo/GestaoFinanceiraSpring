package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/despesas")
public class DespesasController {
	
	private DespesasRepository despesasRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE DESPESAS
	@GetMapping
	public List<Despesas> listardespesas(){
			
		return despesasRepository.findAll();
			
	}

}
