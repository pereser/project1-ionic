package com.rodrigocod.unidonate.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigocod.unidonate.domain.Pedido;
import com.rodrigocod.unidonate.repositories.PedidoRepository;
import com.rodrigocod.unidonate.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo: ," + Pedido.class.getName()));
	}

}
