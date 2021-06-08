package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/vendas")
public class VendasController {
	
	private VendasRepository vendasRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE VENDAS
	@GetMapping
	public List<Vendas> listarvendas(){
			
		return vendasRepository.findAll();
			
	}

}
