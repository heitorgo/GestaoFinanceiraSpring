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
@RequestMapping("/empresas")
public class EmpresasController {
	
	private EmpresasRepository empresasRepository;
	
	//APRESENTANDO TODOS REGISTROS DE EMPRESA
	@GetMapping
	public List<Empresas> listarempresas(){
		
		return empresasRepository.findAll();
		
	}
	//ADICIONANDO EMPRESA
	@PostMapping(path="/add")
	public @ResponseBody String novaEmpresa (@RequestParam String nome_empresa, @RequestParam String email_empresa, @RequestParam String telefone_empresa, @RequestParam String cidade_empresa, @RequestParam String rua_empresa, @RequestParam String num_empresa) {
		Empresas empresa = new Empresas();
		empresa.setNome_empresa(nome_empresa);
		empresa.setEmail_empresa(email_empresa);
		empresa.setTelefone_empresa(telefone_empresa);
		empresa.setCidade_empresa(cidade_empresa);
		empresa.setRua_empresa(rua_empresa);
		empresa.setNum_empresa(num_empresa);
		empresasRepository.save(empresa);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path="/add_empresa")
	public @ResponseBody String novaEmpresa2 (@RequestBody Empresas novaempresa) {
		empresasRepository.save(novaempresa);
		return "Empresa inserida com sucesso";
	}
	// LOCALIZAR EMPRESA
	@GetMapping(path ="/locate_empresa/{id_empresa}")
	public @ResponseBody Optional<Empresas> retornaEmpresa (@PathVariable(required = true,name="id_empresa")
	Long id_empresa){
		return empresasRepository.findById(id_empresa);
	}
	// DELETANDO EMPRESA
	@DeleteMapping(path ="delete_empresa{id_empresa}")
	public @ResponseBody String deleteEmpresa (@PathVariable(required = true, name="id_empresa") Long id_empresa) {
		Optional<Empresas> empresa = empresasRepository.findById(id_empresa);
		if (empresa.isPresent()) {
			empresasRepository.delete(empresa.get());
			return "Empresa deletada com sucesso";
		}
		return "Empresa não encontrada";
	}
	//ATUALIZANDO EMPRESA
	@PutMapping(path="update_empresa/{id_empresa}")
	public @ResponseBody Optional<Empresas> updateEmpresa (@PathVariable(required = true, name = "id_empresa") Long id_empresa, 
			@RequestBody Empresas empresa){
		Optional<Empresas> e = empresasRepository.findById(id_empresa);
		if(e.isPresent()) {
			e.get().setEmail_empresa(empresa.getEmail_empresa());
			e.get().setNome_empresa(empresa.getNome_empresa());
			e.get().setCidade_empresa(empresa.getCidade_empresa());
			e.get().setRua_empresa(empresa.getRua_empresa());
			e.get().setNum_empresa(empresa.getNum_empresa());
			e.get().setTelefone_empresa(empresa.getTelefone_empresa());
			empresasRepository.save(e.get());
			return e;
		}
		
		return null;
	}
	
}
