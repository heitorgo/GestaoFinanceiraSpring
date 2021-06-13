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
@RequestMapping("/custosfixos")
public class CustosFixosController {
	
	private CustosFixosRepository custosfixosRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE CUSTOS FIXOS
	@GetMapping
	public List<CustosFixos> listarcustosfixos(){
		
		return custosfixosRepository.findAll();
		
	}
	//ADICIONANDO CUSTOS FIXOS
	@PostMapping(path="/add")
	public @ResponseBody String novoCustoFixo (@RequestParam Float VALORCUSTOFIXO, @RequestParam String FREQUENCIACUSTO, @RequestParam String DETALHAMENTOCUSTOFIXO, @RequestParam Boolean VERIFCUSTOFIXO, @RequestParam Long IDEMPRESA) {
		CustosFixos custofixo = new CustosFixos();
		custofixo.setVALORCUSTOFIXO(VALORCUSTOFIXO);
		custofixo.setFREQUENCIACUSTO(FREQUENCIACUSTO);
		custofixo.setDETALHAMENTOCUSTOFIXO(DETALHAMENTOCUSTOFIXO);
		custofixo.setVERIFCUSTOFIXO(VERIFCUSTOFIXO);
		custofixo.setIDEMPRESA(IDEMPRESA);
		custosfixosRepository.save(custofixo);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path="/add_custosfixos")
	public @ResponseBody String novoCustoFixo (@RequestBody CustosFixos novocustofixo) {
		custosfixosRepository.save(novocustofixo);
		return "Custo fixo inserido com sucesso";
	}
	// LOCALIZAR CUSTO FIXO
	@GetMapping(path ="/locate_custofixo/{idcustofixo}")
	public @ResponseBody Optional<CustosFixos> retornaCustoFixo (@PathVariable(required = true,name="idcustofixo")
	Long idcustofixo){
		return custosfixosRepository.findById(idcustofixo);
	}
	// DELETANDO CUSTO FIXO
	@DeleteMapping(path ="delete_custofixo{idcustofixo}")
	public @ResponseBody String deleteCustofixo (@PathVariable(required = true, name="idcustofixo") Long idcustofixo) {
		Optional<CustosFixos> custofixo = custosfixosRepository.findById(idcustofixo);
		if (custofixo.isPresent()) {
			custosfixosRepository.delete(custofixo.get());
			return "Custo fixo deletado com sucesso";
		}
		return "Custo fixo não encontrado";
	}
	//ATUALIZANDO CUSTO FIXO 
	@PutMapping(path="update_custofixo/{idcustofixo}")
	public @ResponseBody Optional<CustosFixos> updateCustosFixos (@PathVariable(required = true, name = "idcustofixo") Long idcustofixo, 
			@RequestBody CustosFixos custofixo){
		Optional<CustosFixos> cf = custosfixosRepository.findById(idcustofixo);
		if(cf.isPresent()) {
			cf.get().setVALORCUSTOFIXO(custofixo.getVALORCUSTOFIXO());
			cf.get().setFREQUENCIACUSTO(custofixo.getFREQUENCIACUSTO());
			cf.get().setDETALHAMENTOCUSTOFIXO(custofixo.getDETALHAMENTOCUSTOFIXO());
			cf.get().setVERIFCUSTOFIXO(custofixo.getVERIFCUSTOFIXO());
			cf.get().setIDEMPRESA(custofixo.getIDEMPRESA());
			custosfixosRepository.save(cf.get());
			return cf;
		}
		
		return null;
	}

}
