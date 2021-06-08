package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	private UsuariosRepository usuariosRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE USUARIOS 
	@GetMapping
	public List<Usuarios> listarusuarios(){
				
		return usuariosRepository.findAll();
				
	}

}
