package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Long>{
	
	List<Vendas> findByDATAVENDA(String DATAVENDA);
	List<Custos> findByDATAVENDAContaining (String DATAVENDA);

}
