package com.rodrigocod.unidonate.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigocod.unidonate.domain.Endereco;

@Repository

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
