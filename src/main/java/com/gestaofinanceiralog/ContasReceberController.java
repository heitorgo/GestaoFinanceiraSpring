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
@RequestMapping("/contasreceber")
@CrossOrigin(origins = "*")
public class ContasReceberController {
	
	private ContasReceberRepository contasReceberRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE CONTAS RECEBER
	@GetMapping(path="/all")
	public @ResponseBody List<ContasReceber> listarcontasreceber(){
			
		return contasReceberRepository.findAll();
			
	}
	// ADICIONAR CONTAS RECEBER
	@PostMapping(path="/add")
	public @ResponseBody String novoContasReceber (@RequestBody ContasReceber novacontareceber) {
		contasReceberRepository.save(novacontareceber);
		return "Conta Receber inserida com sucesso";
	}
	// LOCALIZAR CONTAS RECEBER
	@GetMapping(path ="/locate/{id_receber}")
	public @ResponseBody Optional<ContasReceber> retornaContaReceber (@PathVariable(required = true,name="id_receber")
	Long id_receber){
		return contasReceberRepository.findById(id_receber);
	}
	// DELETANDO CONTAS RECEBER
	@DeleteMapping(path ="/delete/{id_receber}")
	public @ResponseBody String deleteContasReceber (@PathVariable(required = true, name="id_receber") Long id_receber) {
		Optional<ContasReceber> contareceber = contasReceberRepository.findById(id_receber);
		if (contareceber.isPresent()) {
			contasReceberRepository.delete(contareceber.get());
			return "Conta Receber deletada com sucesso";
		}
		return "Conta Receber não encontrado";
	}
	//ATUALIZANDO CONTA RECEBER
	@PutMapping(path="/update/{id_receber}")
	public @ResponseBody Optional<ContasReceber> updateContasReceber (@PathVariable(required = true, name = "id_receber") Long id_receber, 
			@RequestBody ContasReceber contareceber){
		Optional<ContasReceber> cr = contasReceberRepository.findById(id_receber);
		if(cr.isPresent()) {
			cr.get().setValor_receber(contareceber.getValor_receber());
			cr.get().setData_receber(contareceber.getData_receber());
			cr.get().setDetalhamento_receber(contareceber.getDetalhamento_receber());
			cr.get().setVerif_receber(contareceber.getVerif_receber());
			cr.get().setId_empresa(contareceber.getId_empresa());
			contasReceberRepository.save(cr.get());
			return cr;
		}
		
		return null;
	}

}
