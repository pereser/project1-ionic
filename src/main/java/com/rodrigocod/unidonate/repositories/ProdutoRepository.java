package com.rodrigocod.unidonate.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigocod.unidonate.domain.Produto;

@Repository

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
