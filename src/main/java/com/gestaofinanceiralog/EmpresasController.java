package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/empresas")
public class EmpresasController {
	
	private EmpresasRepository empresasRepository;
	
	//APRESENTANDO TODOS REGISTROS DE EMPRESA
	@GetMapping
	public List<Empresas> listarempresas(){
		
		return empresasRepository.findAll();
		
	}
	
	//BUSCANDO EMPRESA PELO ID
	@GetMapping("/{idempresa}")
	public ResponseEntity<Empresas> buscar(@PathVariable Long idempresa) {
		
		return empresasRepository.findById(idempresa)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());	
	}
	
	//ADICIONANDO EMPRESA
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Empresas adicionar(@RequestBody Empresas empresas) {
		
		return empresasRepository.save(empresas);
		
	}
	
	//ATUALIZANDO EMPRESA
	@PutMapping("/{idempresa}")
	public ResponseEntity<Empresas> atualizar(@PathVariable Long idempresa, @RequestBody Empresas empresas){
		if ( !empresasRepository.existsById(idempresa)) {
			
			return ResponseEntity.notFound().build();
			
		}
		
		empresas.setIDEMPRESA(idempresa);
		empresas = empresasRepository.save(empresas);
		
		return ResponseEntity.ok(empresas);
	}
	
	//DELETANDO EMPRESA
	@DeleteMapping("/{idempresa}")
	public ResponseEntity<Void> remover(@PathVariable Long idempresa){
		
		if ( !empresasRepository.existsById(idempresa)) {
			
			return ResponseEntity.notFound().build();
			
		}
		
		empresasRepository.deleteById(idempresa);
		return ResponseEntity.noContent().build();
		
	}
	
}
