package com.gestaofinanceiralog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustosRepository extends JpaRepository<Custos, Long>{

}
