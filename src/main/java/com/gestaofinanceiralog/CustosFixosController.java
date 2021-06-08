package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/custosfixos")
public class CustosFixosController {
	
	private CustosFixosRepository custosfixosRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE CUSTOS FIXOS
	@GetMapping
	public List<CustosFixos> listarcustosfixos(){
		
		return custosfixosRepository.findAll();
		
	}

}
