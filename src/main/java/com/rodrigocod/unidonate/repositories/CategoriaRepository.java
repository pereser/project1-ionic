package com.rodrigocod.unidonate.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigocod.unidonate.domain.Categoria;

@Repository

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
