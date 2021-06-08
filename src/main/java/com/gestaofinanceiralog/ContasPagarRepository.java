package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasPagarRepository extends JpaRepository<ContasPagar, Long>{
	
	List<ContasPagar> findByDATAPAGAR (String DATAPAGAR);
	List<ContasPagar> findByDATAPAGARContaining (String DATAPAGAR);

}
