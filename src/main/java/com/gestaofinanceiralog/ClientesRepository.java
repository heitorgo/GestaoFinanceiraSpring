package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
	
	List<Empresas> findByNOMECLIENTE (String NOMECLIENTE);
	List<Empresas> findByNOMECLIENTEContaining (String NOMECLIENTE);

}
