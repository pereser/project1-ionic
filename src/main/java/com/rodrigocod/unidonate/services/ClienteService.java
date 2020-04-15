package com.rodrigocod.unidonate.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigocod.unidonate.domain.Cliente;
import com.rodrigocod.unidonate.repositories.ClienteRepository;
import com.rodrigocod.unidonate.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo: ," + Cliente.class.getName()));
	}

}
