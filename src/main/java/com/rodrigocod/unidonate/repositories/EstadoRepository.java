package com.rodrigocod.unidonate.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigocod.unidonate.domain.Estado;

@Repository

public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
