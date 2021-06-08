package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustosRepository extends JpaRepository<Custos, Long>{
	
	List<Custos> findByDATACUSTO (String DATACUSTO);
	List<Custos> findByDATACUSTOContaining (String DATACUSTO);

}
