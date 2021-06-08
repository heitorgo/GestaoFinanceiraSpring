package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
	
	List<Usuarios> findByLOGIN (String LOGIN);
	List<Usuarios> findByLOGINContaining (String LOGIN);

}
