package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Long>{
	
	List<Empresas> findByNOMEEMPRESA (String NOMEEMPRESA);
	List<Empresas> findByNOMEEMPRESAContaining (String NOMEEMPRESA);

}
