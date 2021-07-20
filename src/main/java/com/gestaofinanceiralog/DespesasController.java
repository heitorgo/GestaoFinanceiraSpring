package com.gestaofinanceiralog;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/despesas")
@CrossOrigin(origins = "*")
public class DespesasController {
	
	private DespesasRepository despesasRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE DESPESAS
	@GetMapping(path="/all")
	public @ResponseBody List<Despesas> listardespesas(){
			
		return despesasRepository.findAll();
			
	}
	// ADICIONANDO DESPESAS
	@PostMapping(path="/add")
	public @ResponseBody String novaDespesa (@RequestBody Despesas novadespesa) {
		despesasRepository.save(novadespesa);
		return "Despesa inserida com sucesso";
	}
	// LOCALIZAR DESPESA
	@GetMapping(path ="/locate/{id_despesa}")
	public @ResponseBody Optional<Despesas> retornaDespesa (@PathVariable(required = true,name="id_despesa")
	Long id_despesa){
		return despesasRepository.findById(id_despesa);
	}
	// DELETANDO DESPESA
	@DeleteMapping(path ="/delete/{id_despesa}")
	public @ResponseBody String deleteDespesa (@PathVariable(required = true, name="id_despesa") Long id_despesa) {
		Optional<Despesas> despesa = despesasRepository.findById(id_despesa);
		if (despesa.isPresent()) {
			despesasRepository.delete(despesa.get());
			return "Despesa deletada com sucesso";
		}
		return "Despesa não encontrada";
	}
	//ATUALIZANDO DESPESA 
	@PutMapping(path="/update/{id_despesa}")
	public @ResponseBody Optional<Despesas> updateDespesa (@PathVariable(required = true, name = "id_despesa") Long id_despesa, 
			@RequestBody Despesas despesa){
		Optional<Despesas> d = despesasRepository.findById(id_despesa);
		if(d.isPresent()) {
			d.get().setValor_despesa(despesa.getValor_despesa());
			d.get().setData_despesa(despesa.getData_despesa());
			d.get().setDetalhamento_despesa(despesa.getDetalhamento_despesa());
			d.get().setVerif_despesa(despesa.getVerif_despesa());
			d.get().setId_empresa(despesa.getId_empresa());
			despesasRepository.save(d.get());
			return d;
		}
		
		return null;
	}

}
