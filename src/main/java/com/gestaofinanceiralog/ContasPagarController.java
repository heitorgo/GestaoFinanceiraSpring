package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/contaspagar")
public class ContasPagarController {
	
	private ContasPagarRepository contasPagarRepository;
	
	//APRESENTANDO TODOS REGISTROS DE CONTAS PAGAR
	@GetMapping
	public List<ContasPagar> listarcontaspagar(){
			
		return contasPagarRepository.findAll();
			
	}

}
