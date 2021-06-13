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
@RequestMapping("/contareceber")
public class ContasReceberController {
	
	private ContasReceberRepository contasReceberRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE CONTAS RECEBER
	@GetMapping
	public List<ContasReceber> listarcontasreceber(){
			
		return contasReceberRepository.findAll();
			
	}
	// ADICIONAR CONTAS RECEBER
	@PostMapping(path="/add")
	public @ResponseBody String novaContaReceber (@RequestParam Float VALORRECEBER, @RequestParam String DATARECEBER, @RequestParam String DETALHAMENTORECEBER, @RequestParam Boolean VERIFRECEBER, @RequestParam Long IDEMPRESA) {
		ContasReceber receber = new ContasReceber();
		receber.setVALORRECEBER(VALORRECEBER);
		receber.setDATARECEBER(DATARECEBER);
		receber.setDETALHAMENTORECEBER(DETALHAMENTORECEBER);
		receber.setVERIFRECEBER(VERIFRECEBER);
		receber.setIDEMPRESA(IDEMPRESA);
		contasReceberRepository.save(receber);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path="/add_contareceber")
	public @ResponseBody String novoContasReceber (@RequestBody ContasReceber novacontareceber) {
		contasReceberRepository.save(novacontareceber);
		return "Conta Receber inserida com sucesso";
	}
	// LOCALIZAR CONTAS RECEBER
	@GetMapping(path ="/locate_contareceber/{idcontareceber}")
	public @ResponseBody Optional<ContasReceber> retornaContaReceber (@PathVariable(required = true,name="idcontareceber")
	Long idcontareceber){
		return contasReceberRepository.findById(idcontareceber);
	}
	// DELETANDO CONTAS RECEBER
	@DeleteMapping(path ="delete_contareceber{idcontareceber}")
	public @ResponseBody String deleteContasReceber (@PathVariable(required = true, name="idcontareceber") Long idcontareceber) {
		Optional<ContasReceber> contareceber = contasReceberRepository.findById(idcontareceber);
		if (contareceber.isPresent()) {
			contasReceberRepository.delete(contareceber.get());
			return "Conta Receber deletada com sucesso";
		}
		return "Conta Receber não encontrado";
	}
	//ATUALIZANDO CONTA RECEBER
	@PutMapping(path="update_contareceber/{idcontareceber}")
	public @ResponseBody Optional<ContasReceber> updateContasReceber (@PathVariable(required = true, name = "idcontareceber") Long idcontareceber, 
			@RequestBody ContasReceber contareceber){
		Optional<ContasReceber> cr = contasReceberRepository.findById(idcontareceber);
		if(cr.isPresent()) {
			cr.get().setVALORRECEBER(contareceber.getVALORRECEBER());
			cr.get().setDATARECEBER(contareceber.getDATARECEBER());
			cr.get().setDETALHAMENTORECEBER(contareceber.getDETALHAMENTORECEBER());
			cr.get().setVERIFRECEBER(contareceber.getVERIFRECEBER());
			cr.get().setIDEMPRESA(contareceber.getIDEMPRESA());
			contasReceberRepository.save(cr.get());
			return cr;
		}
		
		return null;
	}

}
