package com.rodrigocod.unidonate.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigocod.unidonate.domain.Pedido;

@Repository

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
