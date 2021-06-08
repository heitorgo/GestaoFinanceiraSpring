package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustosFixosRepository extends JpaRepository<CustosFixos, Long>{
	
	List<CustosFixos> findByFREQUENCIACUSTO (String FREQUENCIACUSTO);
	List<CustosFixos> findByFREQUENCIACUSTOContaining (String FREQUENCIACUSTO);

}
