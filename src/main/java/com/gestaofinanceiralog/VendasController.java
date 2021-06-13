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
@RequestMapping("/vendas")
public class VendasController {
	
	//TODAS AS VENDAS
	private VendasRepository vendasRepository;
	
	@GetMapping(path="/all")
	public List<Vendas> listarvendas(){
			
		return vendasRepository.findAll();
			
	}
	//ADICIONAR VENDAS
	@PostMapping(path="/add")
	public @ResponseBody String novaVenda (@RequestParam Float VALORVENDA, @RequestParam String DATAVENDA, @RequestParam String DETALHAMENTOVENDA, @RequestParam Boolean VERIFVENDA, @RequestParam Long IDEMPRESA) {
		Vendas venda = new Vendas();
		venda.setVALORVENDA(VALORVENDA);
		venda.setDATAVENDA(DATAVENDA);
		venda.setDETALHAMENTOVENDA(DETALHAMENTOVENDA);
		venda.setVERIFVENDA(VERIFVENDA);
		venda.setIDEMPRESA(IDEMPRESA);
		vendasRepository.save(venda);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path="/add_venda")
	public @ResponseBody String novaVenda2 (@RequestBody Vendas novavenda) {
		vendasRepository.save(novavenda);
		return "Venda inserida com sucesso";
	}
	// LOCALIZAR VENDA
	@GetMapping(path ="/locate_venda/{idvenda}")
	public @ResponseBody Optional<Vendas> retornaVenda (@PathVariable(required = true,name="idvenda")
	Long idvenda){
		return vendasRepository.findById(idvenda);
	}
	// DELETANDO VENDA
	@DeleteMapping(path ="delete_venda{idvenda}")
	public @ResponseBody String deleteVenda (@PathVariable(required = true, name="idvenda") Long idvenda) {
		Optional<Vendas> venda = vendasRepository.findById(idvenda);
		if (venda.isPresent()) {
			vendasRepository.delete(venda.get());
			return "Venda deletada com sucesso";
		}
		return "Venda não encontrado";
	}
	//ATUALIZANDO VENDA
	@PutMapping(path="update_venda/{idvenda}")
	public @ResponseBody Optional<Vendas> updateVenda (@PathVariable(required = true, name = "idvenda") Long idvenda, 
			@RequestBody Vendas venda){
		Optional<Vendas> v = vendasRepository.findById(idvenda);
		if(v.isPresent()) {
			v.get().setVALORVENDA(venda.getVALORVENDA());
			v.get().setDATAVENDA(venda.getDATAVENDA());
			v.get().setDETALHAMENTOVENDA(venda.getDETALHAMENTOVENDA());
			v.get().setVERIFVENDA(venda.getVERIFVENDA());
			v.get().setIDEMPRESA(venda.getIDEMPRESA());
			vendasRepository.save(v.get());
			return v;
		}
		
		return null;
	}

}
