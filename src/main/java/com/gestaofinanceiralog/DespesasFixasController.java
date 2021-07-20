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
@RequestMapping("/despesasfixas")
@CrossOrigin(origins = "*")
public class DespesasFixasController {

	private DespesasFixasRepository despesasfixasRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE DESPESAS FIXAS
	@GetMapping(path= "/all")
	public @ResponseBody List<DespesasFixas> listardespesasfixas(){
		
		return despesasfixasRepository.findAll();
		
	}
	//ADICIONANDO DESPESAS FIXAS
	@PostMapping(path="/add")
	public @ResponseBody String novaDespesaFixa (@RequestBody DespesasFixas novadespesafixa) {
		despesasfixasRepository.save(novadespesafixa);
		return "Despesa fixa inserida com sucesso";
	}
	// LOCALIZAR DESPESA FIXA
	@GetMapping(path ="/locate/{id_despesa_fixa}")
	public @ResponseBody Optional<DespesasFixas> retornaDespesaFixa (@PathVariable(required = true,name="id_despesa_fixa")
	Long id_despesa_fixa){
		return despesasfixasRepository.findById(id_despesa_fixa);
	}
	// DELETANDO DESPESA FIXA
	@DeleteMapping(path ="/delete/{id_despesa_fixa}")
	public @ResponseBody String deleteDespesaFixa (@PathVariable(required = true, name="id_despesa_fixa") Long id_despesa_fixa) {
		Optional<DespesasFixas> despesafixa = despesasfixasRepository.findById(id_despesa_fixa);
		if (despesafixa.isPresent()) {
			despesasfixasRepository.delete(despesafixa.get());
			return "Despesa fixa deletada com sucesso";
		}
		return "Despesa fixa não encontrada";
	}
	//ATUALIZANDO DESPESA FIXA
	@PutMapping(path="/update/{id_despesa_fixa}")
	public @ResponseBody Optional<DespesasFixas> updateDespesaFixa (@PathVariable(required = true, name = "id_despesa_fixa") Long id_despesa_fixa, 
			@RequestBody DespesasFixas despesafixa){
		Optional<DespesasFixas> df = despesasfixasRepository.findById(id_despesa_fixa);
		if(df.isPresent()) {
			df.get().setValor_despesa_fixa(despesafixa.getValor_despesa_fixa());
			df.get().setFrequencia_despesa(despesafixa.getFrequencia_despesa());
			df.get().setDetalhamento_despesa_fixa(despesafixa.getDetalhamento_despesa_fixa());
			df.get().setVerif_despesa_fixa(despesafixa.getVerif_despesa_fixa());
			df.get().setId_empresa(despesafixa.getId_empresa());
			despesasfixasRepository.save(df.get());
			return df;
		}
		
		return null;
	}
}
