package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/contasreceber")
public class ContasReceberController {
	
	private ContasReceberRepository contasReceberRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE CONTAS RECEBER
	@GetMapping
	public List<ContasReceber> listarcontasreceber(){
			
		return contasReceberRepository.findAll();
			
	}

}
