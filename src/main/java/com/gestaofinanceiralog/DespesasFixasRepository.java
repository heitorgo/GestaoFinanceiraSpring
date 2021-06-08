package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesasFixasRepository extends JpaRepository<DespesasFixas, Long>{
	
	List<DespesasFixas> findByFREQUENCIADESPESA (String FREQUENCIADESPESA);
	List<DespesasFixas> findByFREQUENCIADESPESAContaining (String FREQUENCIADESPESA);

}
