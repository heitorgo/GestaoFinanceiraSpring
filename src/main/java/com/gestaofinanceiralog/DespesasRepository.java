package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Long>{
	
	List<Despesas> findByDATADESPESA (String DATADESPESA);
	List<Despesas> findByDATADESPESAContaining (String DATADESPESA);

}
