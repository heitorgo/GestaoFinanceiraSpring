 package com.gestaofinanceiralog;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	//TODOS USUARIOS
	private UsuariosRepository usuariosRepository;
	
	@GetMapping(path="/all")
	public List<Usuarios> listarusuarios(){
				
		return usuariosRepository.findAll();
				
	}
	// ADICIONAR USUARIO
	@PostMapping(path="/add")
	public @ResponseBody String novoUsuario (@RequestParam String LOGIN, @RequestParam String SENHA) {
		Usuarios user = new Usuarios();
		user.setLOGIN(LOGIN);
		user.setSENHA(SENHA);
		usuariosRepository.save(user);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path="/add_usuario")
	public @ResponseBody String novoUsuario2 (@RequestBody Usuarios novousuario) {
		usuariosRepository.save(novousuario);
		return "Usuario inserido com sucesso";
	}
	// LOCALIZAR USUARIO
	@GetMapping(path ="/locate_usuario/{idusuario}")
	public @ResponseBody Optional<Usuarios> retornaUsuario (@PathVariable(required = true,name="idusuario")
	Long idusuario){
		return usuariosRepository.findById(idusuario);
	}
	// DELETANDO USUARIO
	@DeleteMapping(path ="delete_usuario{idusuario}")
	public @ResponseBody String deleteUsuario (@PathVariable(required = true, name="idusuario") Long idusuario) {
		Optional<Usuarios> usuario = usuariosRepository.findById(idusuario);
		if (usuario.isPresent()) {
			usuariosRepository.delete(usuario.get());
			return "Usuário deletado com sucesso";
		}
		return "Usuário não encontrado";
	}
	//ATUALIZANDO USUARIOS
	@PutMapping(path="update_usuario/{id}")
	public @ResponseBody Optional<Usuarios> updateUser (@PathVariable(required = true, name = "idusuario") Long idusuario, 
			@RequestBody Usuarios usuario){
		Optional<Usuarios> u = usuariosRepository.findById(idusuario);
		if(u.isPresent()) {
			u.get().setLOGIN(usuario.getLOGIN());
			u.get().setSENHA(usuario.getSENHA());
			usuariosRepository.save(u.get());
			return u;
		}
		
		return null;
	}
	

}
