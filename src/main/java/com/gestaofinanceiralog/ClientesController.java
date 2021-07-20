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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	private ClientesRepository clientesRepository;
	
	//APRESENTANDO TODOS REGISTROS DE CLIENTES
	@GetMapping
	public List<Clientes> listarclientes(){
			
		return clientesRepository.findAll();
			
	}
	// ADICIONANDO CLIENTE
	
	@PostMapping(path="/add")
	public @ResponseBody String novoCliente (@RequestBody Clientes novocliente) {
		clientesRepository.save(novocliente);
		return "Cliente inserido com sucesso";
	}
	// LOCALIZAR CLIENTES
	@GetMapping(path ="/locate/{id_cliente}")
	public @ResponseBody Optional<Clientes> retornaCliente (@PathVariable(required = true,name="id_cliente")
	Long id_cliente){
		return clientesRepository.findById(id_cliente);
	}
	// DELETANDO CLIENTES
	@DeleteMapping(path ="/delete/{id_cliente}")
	public @ResponseBody String deleteCliente (@PathVariable(required = true, name="id_cliente") Long id_cliente) {
		Optional<Clientes> cliente = clientesRepository.findById(id_cliente);
		if (cliente.isPresent()) {
			clientesRepository.delete(cliente.get());
			return "Cliente deletado com sucesso";
		}
		return "Cliente não encontrado";
	}
	//ATUALIZANDO CLIENTES
	@PutMapping(path="/update/{id_cliente}")
	public @ResponseBody Optional<Clientes> updateClientes (@PathVariable(required = true, name = "id_cliente") Long id_cliente, 
			@RequestBody Clientes cliente){
		Optional<Clientes> cli = clientesRepository.findById(id_cliente);
		if(cli.isPresent()) {
			cli.get().setNome_cliente(cliente.getNome_cliente());
			cli.get().setEmail_cliente(cliente.getEmail_cliente());
			cli.get().setDtanasc_cliente(cliente.getDtanasc_cliente());
			cli.get().setId_empresa(cliente.getId_empresa());
			cli.get().setCpf_cliente(cliente.getCpf_cliente());
			cli.get().setCidade_cliente(cliente.getCidade_cliente());
			cli.get().setBairro_cliente(cliente.getBairro_cliente());
			cli.get().setRua_cliente(cliente.getRua_cliente());
			cli.get().setNumcasa_cliente(cliente.getNumcasa_cliente());
			cli.get().setTelefone_cliente(cliente.getTelefone_cliente());
			clientesRepository.save(cli.get());
			return cli;
		}
		
		return null;
	}

}
