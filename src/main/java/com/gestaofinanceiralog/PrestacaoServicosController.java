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
@RequestMapping("/prestacaoservicos")
public class PrestacaoServicosController {
	
	private PrestacaoServicosRepository servicosRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE SERVIÇOS
	@GetMapping
	public List<PrestacaoServicos> listarservicos(){
			
		return servicosRepository.findAll();
			
	}
	// ADICIONANDO SERVIÇOS
	@PostMapping(path="/add")
	public @ResponseBody String novoServico (@RequestParam Float VALORSERVICO, @RequestParam String DATASERVICO, @RequestParam String DETALHAMENTOSERVICO, @RequestParam Boolean VERIFSERVICO, @RequestParam Long IDEMPRESA) {
		PrestacaoServicos servico = new PrestacaoServicos();
		servico.setVALORSERVICO(VALORSERVICO);
		servico.setDATASERVICO(DATASERVICO);
		servico.setDETALHAMENTOSERVICO(DETALHAMENTOSERVICO);
		servico.setVERIFSERVICO(VERIFSERVICO);
		servico.setIDEMPRESA(IDEMPRESA);
		servicosRepository.save(servico);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path="/addservico")
	public @ResponseBody String novoServico2 (@RequestBody PrestacaoServicos novoservico) {
		servicosRepository.save(novoservico);
		return "Serviço inserido com sucesso";
	}
	// LOCALIZAR SERVICO
	@GetMapping(path ="/locate_venda/{idservico}")
	public @ResponseBody Optional<PrestacaoServicos> retornaServico (@PathVariable(required = true,name="idservico")
	Long idservico){
		return servicosRepository.findById(idservico);
	}
	// DELETANDO SERVIÇOS
	@DeleteMapping(path ="delete_servico{idservico}")
	public @ResponseBody String deleteServico (@PathVariable(required = true, name="idservico") Long idservico) {
		Optional<PrestacaoServicos> servico = servicosRepository.findById(idservico);
		if (servico.isPresent()) {
			servicosRepository.delete(servico.get());
			return "Serviço deletado com sucesso";
		}
		return "Serviço não encontrado";
	}
	//ATUALIZANDO SERVIÇOS
	@PutMapping(path="update_servico/{idservico}")
	public @ResponseBody Optional<PrestacaoServicos> updateServicos (@PathVariable(required = true, name = "idservico") Long idservico, 
			@RequestBody PrestacaoServicos servico){
		Optional<PrestacaoServicos> s = servicosRepository.findById(idservico);
		if(s.isPresent()) {
			s.get().setVALORSERVICO(servico.getVALORSERVICO());
			s.get().setDATASERVICO(servico.getDATASERVICO());
			s.get().setDETALHAMENTOSERVICO(servico.getDETALHAMENTOSERVICO());
			s.get().setVERIFSERVICO(servico.getVERIFSERVICO());
			s.get().setIDEMPRESA(servico.getIDEMPRESA());
			servicosRepository.save(s.get());
			return s;
		}
		
		return null;
	}


}
