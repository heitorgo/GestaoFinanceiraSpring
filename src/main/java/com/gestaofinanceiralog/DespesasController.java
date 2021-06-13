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
@RequestMapping("/despesas")
public class DespesasController {
	
	private DespesasRepository despesasRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE DESPESAS
	@GetMapping
	public List<Despesas> listardespesas(){
			
		return despesasRepository.findAll();
			
	}
	// ADICIONANDO DESPESAS
	@PostMapping(path="/add")
	public @ResponseBody String novaDespesa (@RequestParam Float VALORDESPESA, @RequestParam String DATADESPESA, @RequestParam String DETALHAMENTODESPESA, @RequestParam Boolean VERIFDESPESA, @RequestParam Long IDEMPRESA) {
		Despesas despesa = new Despesas();
		despesa.setVALORDESPESA(VALORDESPESA);
		despesa.setDATADESPESA(DATADESPESA);
		despesa.setDETALHAMENTODESPESA(DETALHAMENTODESPESA);
		despesa.setVERIFDESPESA(VERIFDESPESA);
		despesa.setIDEMPRESA(IDEMPRESA);
		despesasRepository.save(despesa);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path="/add_despesa")
	public @ResponseBody String novaDespesa (@RequestBody Despesas novadespesa) {
		despesasRepository.save(novadespesa);
		return "Despesa inserida com sucesso";
	}
	// LOCALIZAR DESPESA
	@GetMapping(path ="/locate_despesa/{iddespesa}")
	public @ResponseBody Optional<Despesas> retornaDespesa (@PathVariable(required = true,name="iddespesa")
	Long iddespesa){
		return despesasRepository.findById(iddespesa);
	}
	// DELETANDO DESPESA
	@DeleteMapping(path ="delete_despesa{iddespesa}")
	public @ResponseBody String deleteDespesa (@PathVariable(required = true, name="iddespesa") Long iddespesa) {
		Optional<Despesas> despesa = despesasRepository.findById(iddespesa);
		if (despesa.isPresent()) {
			despesasRepository.delete(despesa.get());
			return "Despesa deletada com sucesso";
		}
		return "Despesa não encontrada";
	}
	//ATUALIZANDO DESPESA 
	@PutMapping(path="update_despesa/{iddespesa}")
	public @ResponseBody Optional<Despesas> updateDespesa (@PathVariable(required = true, name = "iddespesa") Long iddespesa, 
			@RequestBody Despesas despesa){
		Optional<Despesas> d = despesasRepository.findById(iddespesa);
		if(d.isPresent()) {
			d.get().setVALORDESPESA(despesa.getVALORDESPESA());
			d.get().setDATADESPESA(despesa.getDATADESPESA());
			d.get().setDETALHAMENTODESPESA(despesa.getDETALHAMENTODESPESA());
			d.get().setVERIFDESPESA(despesa.getVERIFDESPESA());
			d.get().setIDEMPRESA(despesa.getIDEMPRESA());
			despesasRepository.save(d.get());
			return d;
		}
		
		return null;
	}

}
