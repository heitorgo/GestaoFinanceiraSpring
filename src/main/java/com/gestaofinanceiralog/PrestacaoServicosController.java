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
@RequestMapping("/servicos")
@CrossOrigin(origins = "*")
public class PrestacaoServicosController {
	
	private PrestacaoServicosRepository servicosRepository;
	
	//APRESENTANDO TODOS OS REGISTROS DE SERVIÇOS
	@GetMapping(path="/all")
	public @ResponseBody List<PrestacaoServicos> listarservicos(){
			
		return servicosRepository.findAll();
			
	}
	// ADICIONANDO SERVIÇOS
	@PostMapping(path="/add")
	public @ResponseBody String novoServico2 (@RequestBody PrestacaoServicos novoservico) {
		servicosRepository.save(novoservico);
		return "Serviço inserido com sucesso";
	}
	// LOCALIZAR SERVICO
	@GetMapping(path ="/locate/{id_servico}")
	public @ResponseBody Optional<PrestacaoServicos> retornaServico (@PathVariable(required = true,name="id_servico")
	Long id_servico){
		return servicosRepository.findById(id_servico);
	}
	// DELETANDO SERVIÇOS
	@DeleteMapping(path ="/delete/{id_servico}")
	public @ResponseBody String deleteServico (@PathVariable(required = true, name="id_servico") Long id_servico) {
		Optional<PrestacaoServicos> servico = servicosRepository.findById(id_servico);
		if (servico.isPresent()) {
			servicosRepository.delete(servico.get());
			return "Serviço deletado com sucesso";
		}
		return "Serviço não encontrado";
	}
	//ATUALIZANDO SERVIÇOS
	@PutMapping(path="/update/{id_servico}")
	public @ResponseBody Optional<PrestacaoServicos> updateServicos (@PathVariable(required = true, name = "id_servico") Long id_servico, 
			@RequestBody PrestacaoServicos servico){
		Optional<PrestacaoServicos> s = servicosRepository.findById(id_servico);
		if(s.isPresent()) {
			s.get().setValor_servico(servico.getValor_servico());
			s.get().setData_servico(servico.getData_servico());
			s.get().setDetalhamento_servico(servico.getDetalhamento_servico());
			s.get().setVerif_servico(servico.getVerif_servico());
			s.get().setId_empresa(servico.getId_empresa());
			servicosRepository.save(s.get());
			return s;
		}
		
		return null;
	}


}
