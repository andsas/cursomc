package com.br.andsas.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.andsas.domain.Cliente;
import com.br.andsas.repositories.ClienteRepository;
import com.br.andsas.servicies.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente findById(Integer id) {		
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado. Id: " + id + ". Tipo: " + Cliente.class.getName())
		);
	}

}
