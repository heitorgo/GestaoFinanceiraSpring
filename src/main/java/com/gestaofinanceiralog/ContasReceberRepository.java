package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasReceberRepository extends JpaRepository<ContasReceber, Long> {
	
	List<ContasReceber> findByDATARECEBER (String DATARECEBER);
	List<ContasReceber> findByDATARECEBERContaining (String DATARECEBER);

}
