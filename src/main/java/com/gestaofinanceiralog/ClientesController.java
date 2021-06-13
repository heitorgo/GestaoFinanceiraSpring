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
	public @ResponseBody String novoCliente (@RequestParam String NOMECLIENTE, @RequestParam String DTANASCCLIENTE, @RequestParam String EMAILCLIENTE, @RequestParam String CPFCLIENTE, 
			@RequestParam String CIDADECLIENTE, @RequestParam String RUACLIENTE, @RequestParam String BAIRROCLIENTE, @RequestParam String NUMCASACLIENTE, @RequestParam String CONTATOCLIENTE, 
			@RequestParam String COMPLCLIENTE, @RequestParam Long IDEMPRESA) {
		Clientes cliente = new Clientes();
		cliente.setNOMECLIENTE(NOMECLIENTE);
		cliente.setDTANASCCLIENTE(DTANASCCLIENTE);
		cliente.setEMAILCLIENTE(EMAILCLIENTE);
		cliente.setCPFCLIENTE(CPFCLIENTE);
		cliente.setCIDADECLIENTE(CIDADECLIENTE);
		cliente.setRUACLIENTE(RUACLIENTE);
		cliente.setBAIRROCLIENTE(BAIRROCLIENTE);
		cliente.setNUMCASACLIENTE(NUMCASACLIENTE);
		cliente.setCONTATOCLIENTE(CONTATOCLIENTE);
		cliente.setCOMPLCLIENTE(COMPLCLIENTE);
		cliente.setIDEMPRESA(IDEMPRESA);
		clientesRepository.save(cliente);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path="/add_cliente")
	public @ResponseBody String novoCliente (@RequestBody Clientes novocliente) {
		clientesRepository.save(novocliente);
		return "Cliente inserido com sucesso";
	}
	// LOCALIZAR CLIENTES
	@GetMapping(path ="/locate_cliente/{idcliente}")
	public @ResponseBody Optional<Clientes> retornaCliente (@PathVariable(required = true,name="idcliente")
	Long idcliente){
		return clientesRepository.findById(idcliente);
	}
	// DELETANDO CLIENTES
	@DeleteMapping(path ="delete_cliente{idcliente}")
	public @ResponseBody String deleteCliente (@PathVariable(required = true, name="idcliente") Long idcliente) {
		Optional<Clientes> cliente = clientesRepository.findById(idcliente);
		if (cliente.isPresent()) {
			clientesRepository.delete(cliente.get());
			return "Cliente deletado com sucesso";
		}
		return "Cliente não encontrado";
	}
	//ATUALIZANDO CLIENTES
	@PutMapping(path="update_cliente/{idcliente}")
	public @ResponseBody Optional<Clientes> updateClientes (@PathVariable(required = true, name = "idcliente") Long idcliente, 
			@RequestBody Clientes cliente){
		Optional<Clientes> cli = clientesRepository.findById(idcliente);
		if(cli.isPresent()) {
			cli.get().setNOMECLIENTE(cliente.getNOMECLIENTE());
			cli.get().setEMAILCLIENTE(cliente.getEMAILCLIENTE());
			cli.get().setDTANASCCLIENTE(cliente.getDTANASCCLIENTE());
			cli.get().setIDEMPRESA(cliente.getIDEMPRESA());
			cli.get().setCPFCLIENTE(cliente.getCPFCLIENTE());
			cli.get().setCIDADECLIENTE(cliente.getCIDADECLIENTE());
			cli.get().setBAIRROCLIENTE(cliente.getBAIRROCLIENTE());
			cli.get().setRUACLIENTE(cliente.getRUACLIENTE());
			cli.get().setNUMCASACLIENTE(cliente.getNUMCASACLIENTE());
			cli.get().setCOMPLCLIENTE(cliente.getCOMPLCLIENTE());
			cli.get().setCONTATOCLIENTE(cliente.getCONTATOCLIENTE());
			clientesRepository.save(cli.get());
			return cli;
		}
		
		return null;
	}

}
