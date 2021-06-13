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
@RequestMapping("/contapagar")
public class ContasPagarController {
	
	private ContasPagarRepository contasPagarRepository;
	
	//APRESENTANDO TODOS REGISTROS DE CONTAS PAGAR
	@GetMapping
	public List<ContasPagar> listarcontaspagar(){
			
		return contasPagarRepository.findAll();
			
	}
	//ADICIONAR CONTA PAGAR
	@PostMapping(path="/add")
	public @ResponseBody String novaContaPagar (@RequestParam Float VALORPAGAR, @RequestParam String DATAPAGAR, @RequestParam String DETALHAMENTOPAGAR, @RequestParam Boolean VERIFPAGAR, @RequestParam Long IDEMPRESA) {
		ContasPagar pagar = new ContasPagar();
		pagar.setVALORPAGAR(VALORPAGAR);
		pagar.setDATAPAGAR(DATAPAGAR);
		pagar.setDETALHAMENTOPAGAR(DETALHAMENTOPAGAR);
		pagar.setVERIFPAGAR(VERIFPAGAR);
		pagar.setIDEMPRESA(IDEMPRESA);
		contasPagarRepository.save(pagar);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path="/add_contapagar")
	public @ResponseBody String novoContasPagar (@RequestBody ContasPagar novacontapagar) {
		contasPagarRepository.save(novacontapagar);
		return "Conta Pagar inserido com sucesso";
	}
	// LOCALIZAR CONTAS PAGAR
	@GetMapping(path ="/locate_contapagar/{idcontareceber}")
	public @ResponseBody Optional<ContasPagar> retornaContaPagar (@PathVariable(required = true,name="idcontapagar")
	Long idcontapagar){
		return contasPagarRepository.findById(idcontapagar);
	}
	// DELETANDO CONTAS PAGAR
	@DeleteMapping(path ="delete_contapagar{idcontapagar}")
	public @ResponseBody String deleteContasPagar (@PathVariable(required = true, name="idcontapagar") Long idcontapagar) {
		Optional<ContasPagar> contapagar = contasPagarRepository.findById(idcontapagar);
		if (contapagar.isPresent()) {
			contasPagarRepository.delete(contapagar.get());
			return "Conta Pagar deletada com sucesso";
		}
		return "Conta Pagar não encontrada";
	}
	//ATUALIZANDO CONTA PAGAR
	@PutMapping(path="update_contapagar/{idcontapagar}")
	public @ResponseBody Optional<ContasPagar> updateContasPagar (@PathVariable(required = true, name = "idcontapagar") Long idcontapagar, 
			@RequestBody ContasPagar contapagar){
		Optional<ContasPagar> cp = contasPagarRepository.findById(idcontapagar);
		if(cp.isPresent()) {
			cp.get().setVALORPAGAR(contapagar.getVALORPAGAR());
			cp.get().setDATAPAGAR(contapagar.getDATAPAGAR());
			cp.get().setDETALHAMENTOPAGAR(contapagar.getDETALHAMENTOPAGAR());
			cp.get().setVERIFPAGAR(contapagar.getVERIFPAGAR());
			cp.get().setIDEMPRESA(contapagar.getIDEMPRESA());
			contasPagarRepository.save(cp.get());
			return cp;
		}
		
		return null;
	}

}
