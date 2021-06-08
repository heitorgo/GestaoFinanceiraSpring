package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	private ClientesRepository clientesRepository;
	
	//APRESENTANDO TODOS REGISTROS DE CLIENTES
	@GetMapping
	public List<Clientes> listarclientes(){
			
		return clientesRepository.findAll();
			
	}

}
