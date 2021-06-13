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
	public @ResponseBody String novaEmpresa (@RequestParam String NOMEEMPRESA, @RequestParam String EMAILEMPRESA, @RequestParam String CONTATOEMPRESA, @RequestParam String CIDADEEMPRESA, @RequestParam String RUAEMPRESA, @RequestParam String NUMEMPRESA) {
		Empresas empresa = new Empresas();
		empresa.setNOMEEMPRESA(NOMEEMPRESA);
		empresa.setEMAILEMPRESA(EMAILEMPRESA);
		empresa.setCONTATOEMPRESA(CONTATOEMPRESA);
		empresa.setCIDADEEMPRESA(CIDADEEMPRESA);
		empresa.setRUAEMPRESA(RUAEMPRESA);
		empresa.setNUMEMPRESA(NUMEMPRESA);
		empresasRepository.save(empresa);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path="/add_empresa")
	public @ResponseBody String novaEmpresa2 (@RequestBody Empresas novaempresa) {
		empresasRepository.save(novaempresa);
		return "Empresa inserida com sucesso";
	}
	// LOCALIZAR EMPRESA
	@GetMapping(path ="/locate_empresa/{idempresa}")
	public @ResponseBody Optional<Empresas> retornaEmpresa (@PathVariable(required = true,name="idempresa")
	Long idempresa){
		return empresasRepository.findById(idempresa);
	}
	// DELETANDO EMPRESA
	@DeleteMapping(path ="delete_empresa{idempresa}")
	public @ResponseBody String deleteEmpresa (@PathVariable(required = true, name="idempresa") Long idempresa) {
		Optional<Empresas> empresa = empresasRepository.findById(idempresa);
		if (empresa.isPresent()) {
			empresasRepository.delete(empresa.get());
			return "Empresa deletada com sucesso";
		}
		return "Empresa não encontrada";
	}
	//ATUALIZANDO EMPRESA
	@PutMapping(path="update_empresa/{id}")
	public @ResponseBody Optional<Empresas> updateEmpresa (@PathVariable(required = true, name = "idempresa") Long idempresa, 
			@RequestBody Empresas empresa){
		Optional<Empresas> e = empresasRepository.findById(idempresa);
		if(e.isPresent()) {
			e.get().setEMAILEMPRESA(empresa.getEMAILEMPRESA());
			e.get().setNOMEEMPRESA(empresa.getNOMEEMPRESA());
			e.get().setCIDADEEMPRESA(empresa.getCIDADEEMPRESA());
			e.get().setRUAEMPRESA(empresa.getRUAEMPRESA());
			e.get().setNUMEMPRESA(empresa.getNUMEMPRESA());
			e.get().setCONTATOEMPRESA(empresa.getCONTATOEMPRESA());
			empresasRepository.save(e.get());
			return e;
		}
		
		return null;
	}
	
}
