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
@RequestMapping("/custos")
@CrossOrigin(origins = "*")
public class CustosController {
	
	private CustosRepository custosRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE CUSTOS
	@GetMapping(path="/all")
	public @ResponseBody List<Custos> listarcustos(){
			
		return custosRepository.findAll();
			
	}
	// ADICIONANDO CUSTOS
	@PostMapping(path="/add")
	public @ResponseBody String novoCusto (@RequestBody Custos novocusto) {
		custosRepository.save(novocusto);
		return "Custo inserido com sucesso";
	}
	// LOCALIZAR CUSTO
	@GetMapping(path ="/locate/{id_custo}")
	public @ResponseBody Optional<Custos> retornaCusto (@PathVariable(required = true,name="id_custo")
	Long id_custo){
		return custosRepository.findById(id_custo);
	}
	// DELETANDO CUSTO
	@DeleteMapping(path ="/delete/{id_custo}")
	public @ResponseBody String deleteCusto (@PathVariable(required = true, name="id_custo") Long id_custo) {
		Optional<Custos> custo = custosRepository.findById(id_custo);
		if (custo.isPresent()) {
			custosRepository.delete(custo.get());
			return "Custo deletado com sucesso";
		}
		return "Custo não encontrado";
	}
	//ATUALIZANDO CUSTO
	@PutMapping(path="/update/{id_custo}")
	public @ResponseBody Optional<Custos> updateCustos (@PathVariable(required = true, name = "id_custo") Long id_custo, 
			@RequestBody Custos custo){
		Optional<Custos> c = custosRepository.findById(id_custo);
		if(c.isPresent()) {
			c.get().setValor_custo(custo.getValor_custo());
			c.get().setData_custo(custo.getData_custo());
			c.get().setDetalhamento_custo(custo.getDetalhamento_custo());
			c.get().setVerif_custo(custo.getVerif_custo());
			c.get().setId_empresa(custo.getId_empresa());
			custosRepository.save(c.get());
			return c;
		}
		
		return null;
	}

}
