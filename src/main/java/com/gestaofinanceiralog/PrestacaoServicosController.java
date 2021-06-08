package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/prestacaoservicos")
public class PrestacaoServicosController {
	
	private PrestacaoServicosRepository servicosRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE SERVIÇOS
	@GetMapping
	public List<PrestacaoServicos> listarservicos(){
			
		return servicosRepository.findAll();
			
	}

}
