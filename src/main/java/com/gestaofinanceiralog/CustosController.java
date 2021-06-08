package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/custos")
public class CustosController {
	
	private CustosRepository custosRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE CUSTOS
	@GetMapping
	public List<Custos> listarcustos(){
			
		return custosRepository.findAll();
			
	}

}
