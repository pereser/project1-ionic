package com.rodrigocod.unidonate.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigocod.unidonate.domain.Cidade;

@Repository

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
