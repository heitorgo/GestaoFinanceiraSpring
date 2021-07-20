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
@RequestMapping("/custosfixos")
@CrossOrigin(origins = "*")
public class CustosFixosController {
	
	private CustosFixosRepository custosfixosRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE CUSTOS FIXOS
	@GetMapping(path="/all")
	public @ResponseBody List<CustosFixos> listarcustosfixos(){
		
		return custosfixosRepository.findAll();
		
	}
	//ADICIONANDO CUSTOS FIXOS
	@PostMapping(path="/add")
	public @ResponseBody String novoCustoFixo (@RequestBody CustosFixos novocustofixo) {
		custosfixosRepository.save(novocustofixo);
		return "Custo fixo inserido com sucesso";
	}
	// LOCALIZAR CUSTO FIXO
	@GetMapping(path ="/locate/{id_custo_fixo}")
	public @ResponseBody Optional<CustosFixos> retornaCustoFixo (@PathVariable(required = true,name="id_custo_fixo")
	Long id_custo_fixo){
		return custosfixosRepository.findById(id_custo_fixo);
	}
	// DELETANDO CUSTO FIXO
	@DeleteMapping(path ="/delete/{id_custo_fixo}")
	public @ResponseBody String deleteCustofixo (@PathVariable(required = true, name="id_custo_fixo") Long id_custo_fixo) {
		Optional<CustosFixos> custofixo = custosfixosRepository.findById(id_custo_fixo);
		if (custofixo.isPresent()) {
			custosfixosRepository.delete(custofixo.get());
			return "Custo fixo deletado com sucesso";
		}
		return "Custo fixo não encontrado";
	}
	//ATUALIZANDO CUSTO FIXO 
	@PutMapping(path="/update/{id_custo_fixo}")
	public @ResponseBody Optional<CustosFixos> updateCustosFixos (@PathVariable(required = true, name = "id_custo_fixo") Long id_custo_fixo, 
			@RequestBody CustosFixos custofixo){
		Optional<CustosFixos> cf = custosfixosRepository.findById(id_custo_fixo);
		if(cf.isPresent()) {
			cf.get().setValor_custo_fixo(custofixo.getValor_custo_fixo());
			cf.get().setFrequencia_custo(custofixo.getFrequencia_custo());
			cf.get().setDetalhamento_custo_fixo(custofixo.getDetalhamento_custo_fixo());
			cf.get().setVerif_custo_fixo(custofixo.getVerif_custo_fixo());
			cf.get().setId_empresa(custofixo.getId_empresa());
			custosfixosRepository.save(cf.get());
			return cf;
		}
		
		return null;
	}

}
