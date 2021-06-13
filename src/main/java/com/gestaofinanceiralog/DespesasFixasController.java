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
@RequestMapping("/despesasfixas")
public class DespesasFixasController {

	private DespesasFixasRepository despesasfixasRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE DESPESAS FIXAS
	@GetMapping
	public List<DespesasFixas> listardespesasfixas(){
		
		return despesasfixasRepository.findAll();
		
	}
	//ADICIONANDO DESPESAS FIXAS
	@PostMapping(path="/add")
	public @ResponseBody String novaDespesaFixa (@RequestParam Float VALORDESPESAFIXA, @RequestParam String FREQUENCIADESPESA, @RequestParam String DETALHAMENTODESPESAFIXA, @RequestParam Boolean VERIFDESPESAFIXA, @RequestParam Long IDEMPRESA) {
		DespesasFixas despesafixa = new DespesasFixas();
		despesafixa.setVALORDESPESAFIXA(VALORDESPESAFIXA);
		despesafixa.setFREQUENCIADESPESA(FREQUENCIADESPESA);
		despesafixa.setDETALHAMENTODESPESAFIXA(DETALHAMENTODESPESAFIXA);
		despesafixa.setVERIFDESPESAFIXA(VERIFDESPESAFIXA);
		despesafixa.setIDEMPRESA(IDEMPRESA);
		despesasfixasRepository.save(despesafixa);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path="/add_despesafixa")
	public @ResponseBody String novaDespesaFixa (@RequestBody DespesasFixas novadespesafixa) {
		despesasfixasRepository.save(novadespesafixa);
		return "Despesa fixa inserida com sucesso";
	}
	// LOCALIZAR DESPESA FIXA
	@GetMapping(path ="/locate_despesafixa/{iddespesafixa}")
	public @ResponseBody Optional<DespesasFixas> retornaDespesaFixa (@PathVariable(required = true,name="iddespesafixa")
	Long iddespesafixa){
		return despesasfixasRepository.findById(iddespesafixa);
	}
	// DELETANDO DESPESA FIXA
	@DeleteMapping(path ="delete_despesafixa{iddespesafixa}")
	public @ResponseBody String deleteDespesaFixa (@PathVariable(required = true, name="iddespesafixa") Long iddespesafixa) {
		Optional<DespesasFixas> despesafixa = despesasfixasRepository.findById(iddespesafixa);
		if (despesafixa.isPresent()) {
			despesasfixasRepository.delete(despesafixa.get());
			return "Despesa fixa deletada com sucesso";
		}
		return "Despesa fixa não encontrada";
	}
	//ATUALIZANDO DESPESA FIXA
	@PutMapping(path="update_despesafixa/{iddespesafixa}")
	public @ResponseBody Optional<DespesasFixas> updateDespesaFixa (@PathVariable(required = true, name = "iddespesafixa") Long iddespesafixa, 
			@RequestBody DespesasFixas despesafixa){
		Optional<DespesasFixas> df = despesasfixasRepository.findById(iddespesafixa);
		if(df.isPresent()) {
			df.get().setVALORDESPESAFIXA(despesafixa.getVALORDESPESAFIXA());
			df.get().setFREQUENCIADESPESA(despesafixa.getFREQUENCIADESPESA());
			df.get().setDETALHAMENTODESPESAFIXA(despesafixa.getDETALHAMENTODESPESAFIXA());
			df.get().setVERIFDESPESAFIXA(despesafixa.getVERIFDESPESAFIXA());
			df.get().setIDEMPRESA(despesafixa.getIDEMPRESA());
			despesasfixasRepository.save(df.get());
			return df;
		}
		
		return null;
	}
}
