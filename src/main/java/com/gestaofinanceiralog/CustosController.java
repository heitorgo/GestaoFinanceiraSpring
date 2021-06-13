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
@RequestMapping("/custos")
public class CustosController {
	
	private CustosRepository custosRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE CUSTOS
	@GetMapping
	public List<Custos> listarcustos(){
			
		return custosRepository.findAll();
			
	}
	// ADICIONANDO CUSTOS
	@PostMapping(path="/add")
	public @ResponseBody String novoCusto (@RequestParam Float VALORCUSTO, @RequestParam String DATACUSTO, @RequestParam String DETALHAMENTOCUSTO, @RequestParam Boolean VERIFCUSTO, @RequestParam Long IDEMPRESA) {
		Custos custo = new Custos();
		custo.setVALORCUSTO(VALORCUSTO);
		custo.setDATACUSTO(DATACUSTO);
		custo.setDETALHAMENTOCUSTO(DETALHAMENTOCUSTO);
		custo.setVERIFCUSTO(VERIFCUSTO);
		custo.setIDEMPRESA(IDEMPRESA);
		custosRepository.save(custo);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path="/add_custos")
	public @ResponseBody String novoCusto (@RequestBody Custos novocusto) {
		custosRepository.save(novocusto);
		return "Custo inserido com sucesso";
	}
	// LOCALIZAR CUSTO
	@GetMapping(path ="/locate_custo/{idcusto}")
	public @ResponseBody Optional<Custos> retornaCusto (@PathVariable(required = true,name="idcusto")
	Long idcusto){
		return custosRepository.findById(idcusto);
	}
	// DELETANDO CUSTO
	@DeleteMapping(path ="delete_custo{idcusto}")
	public @ResponseBody String deleteCusto (@PathVariable(required = true, name="idcusto") Long idcusto) {
		Optional<Custos> custo = custosRepository.findById(idcusto);
		if (custo.isPresent()) {
			custosRepository.delete(custo.get());
			return "Custo deletado com sucesso";
		}
		return "Custo não encontrado";
	}
	//ATUALIZANDO CUSTO
	@PutMapping(path="update_custo/{idcusto}")
	public @ResponseBody Optional<Custos> updateCustos (@PathVariable(required = true, name = "idcusto") Long idcusto, 
			@RequestBody Custos custo){
		Optional<Custos> c = custosRepository.findById(idcusto);
		if(c.isPresent()) {
			c.get().setVALORCUSTO(custo.getVALORCUSTO());
			c.get().setDATACUSTO(custo.getDATACUSTO());
			c.get().setDETALHAMENTOCUSTO(custo.getDETALHAMENTOCUSTO());
			c.get().setVERIFCUSTO(custo.getVERIFCUSTO());
			c.get().setIDEMPRESA(custo.getIDEMPRESA());
			custosRepository.save(c.get());
			return c;
		}
		
		return null;
	}

}
