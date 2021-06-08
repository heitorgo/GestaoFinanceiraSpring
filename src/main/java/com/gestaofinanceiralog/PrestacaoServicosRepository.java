package com.gestaofinanceiralog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestacaoServicosRepository extends JpaRepository<PrestacaoServicos, Long>{
	
	List<PrestacaoServicos> findByDATASERVICO (String DATASERVICO);
	List<PrestacaoServicos> findByDATASERVICOContaining (String DATASERVICO);

}
