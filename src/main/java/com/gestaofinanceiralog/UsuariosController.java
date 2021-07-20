 package com.gestaofinanceiralog;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuariosController {
	
	@Autowired
	UsuariosRepository usuariosRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Usuarios> listarusuarios(){
				
		return usuariosRepository.findAll();
				
	}
	// ADICIONAR USUARIO
	@PostMapping(path="/add")
	public @ResponseBody String novoUsuario (@RequestBody Usuarios novousuario) {
		usuariosRepository.save(novousuario);
		return "Usuario inserido com sucesso";
	}
	// LOCALIZAR USUARIO
	@GetMapping(path ="/locate/{id_usuario}")
	public @ResponseBody Optional<Usuarios> retornaUsuario (@PathVariable(required = true,name="id_usuario")
	Long id_usuario){
		return usuariosRepository.findById(id_usuario);
	}
	// DELETANDO USUARIO
	@DeleteMapping(path ="/delete/{id_usuario}")
	public @ResponseBody String deleteUsuario (@PathVariable(required = true, name="id_usuario") Long id_usuario) {
		Optional<Usuarios> usuario = usuariosRepository.findById(id_usuario);
		if (usuario.isPresent()) {
			usuariosRepository.delete(usuario.get());
			return "Usuário deletado com sucesso";
		}
		return "Usuário não encontrado";
	}
	//ATUALIZANDO USUARIOS
	@PutMapping(path="/update/{id_usuario}")
	public @ResponseBody Optional<Usuarios> updateUser (@PathVariable(required = true, name = "id_usuario") Long id_usuario, 
			@RequestBody Usuarios usuario){
		Optional<Usuarios> u = usuariosRepository.findById(id_usuario);
		if(u.isPresent()) {
			u.get().setEmail_usuario(usuario.getEmail_usuario());
			u.get().setSenha_usuario(usuario.getSenha_usuario());
			usuariosRepository.save(u.get());
			return u;
		}
		
		return null;
	}
	

}
