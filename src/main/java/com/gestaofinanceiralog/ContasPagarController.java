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
@RequestMapping("/contaspagar")
@CrossOrigin(origins = "*")
public class ContasPagarController {
	
	private ContasPagarRepository contasPagarRepository;
	
	//APRESENTANDO TODOS REGISTROS DE CONTAS PAGAR
	@GetMapping(path="/all")
	public @ResponseBody List<ContasPagar> listarcontaspagar(){
			
		return contasPagarRepository.findAll();
			
	}
	//ADICIONAR CONTA PAGAR
	@PostMapping(path="/add")
	public @ResponseBody String novoContasPagar (@RequestBody ContasPagar novacontapagar) {
		contasPagarRepository.save(novacontapagar);
		return "Conta Pagar inserida com sucesso";
	}
	// LOCALIZAR CONTAS PAGAR
	@GetMapping(path ="/locate/{id_pagar}")
	public @ResponseBody Optional<ContasPagar> retornaContaPagar (@PathVariable(required = true,name="id_pagar")
	Long id_pagar){
		return contasPagarRepository.findById(id_pagar);
	}
	// DELETANDO CONTAS PAGAR
	@DeleteMapping(path ="/delete/{id_pagar}")
	public @ResponseBody String deleteContasPagar (@PathVariable(required = true, name="id_pagar") Long id_pagar) {
		Optional<ContasPagar> contapagar = contasPagarRepository.findById(id_pagar);
		if (contapagar.isPresent()) {
			contasPagarRepository.delete(contapagar.get());
			return "Conta Pagar deletada com sucesso";
		}
		return "Conta Pagar não encontrada";
	}
	//ATUALIZANDO CONTA PAGAR
	@PutMapping(path="/update/{id_pagar}")
	public @ResponseBody Optional<ContasPagar> updateContasPagar (@PathVariable(required = true, name = "id_pagar") Long id_pagar, 
			@RequestBody ContasPagar contapagar){
		Optional<ContasPagar> cp = contasPagarRepository.findById(id_pagar);
		if(cp.isPresent()) {
			cp.get().setValor_pagar(contapagar.getValor_pagar());
			cp.get().setData_pagar(contapagar.getData_pagar());
			cp.get().setDetalhamento_pagar(contapagar.getDetalhamento_pagar());
			cp.get().setVerif_pagar(contapagar.getVerif_pagar());
			cp.get().setId_empresa(contapagar.getId_empresa());
			contasPagarRepository.save(cp.get());
			return cp;
		}
		
		return null;
	}

}
