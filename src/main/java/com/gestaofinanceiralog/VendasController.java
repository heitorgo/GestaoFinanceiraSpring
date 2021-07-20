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
@RequestMapping("/vendas")
@CrossOrigin(origins = "*")
public class VendasController {
	
	//TODAS AS VENDAS
	private VendasRepository vendasRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody List<Vendas> listarvendas(){
			
		return vendasRepository.findAll();
			
	}
	//ADICIONAR VENDAS
	@PostMapping(path="/add")
	public @ResponseBody String novaVenda2 (@RequestBody Vendas novavenda) {
		vendasRepository.save(novavenda);
		return "Venda inserida com sucesso";
	}
	// LOCALIZAR VENDA
	@GetMapping(path ="/locate/{id_venda}")
	public @ResponseBody Optional<Vendas> retornaVenda (@PathVariable(required = true,name="id_venda")
	Long id_venda){
		return vendasRepository.findById(id_venda);
	}
	// DELETANDO VENDA
	@DeleteMapping(path ="/delete/{id_venda}")
	public @ResponseBody String deleteVenda (@PathVariable(required = true, name="id_venda") Long id_venda) {
		Optional<Vendas> venda = vendasRepository.findById(id_venda);
		if (venda.isPresent()) {
			vendasRepository.delete(venda.get());
			return "Venda deletada com sucesso";
		}
		return "Venda não encontrado";
	}
	//ATUALIZANDO VENDA
	@PutMapping(path="/update/{id_venda}")
	public @ResponseBody Optional<Vendas> updateVenda (@PathVariable(required = true, name = "id_venda") Long id_venda, 
			@RequestBody Vendas venda){
		Optional<Vendas> v = vendasRepository.findById(id_venda);
		if(v.isPresent()) {
			v.get().setValor_venda(venda.getValor_venda());
			v.get().setData_venda(venda.getData_venda());
			v.get().setDetalhamento_venda(venda.getDetalhamento_venda());
			v.get().setVerif_venda(venda.getVerif_venda());
			v.get().setId_empresa(venda.getId_empresa());
			vendasRepository.save(v.get());
			return v;
		}
		
		return null;
	}

}
