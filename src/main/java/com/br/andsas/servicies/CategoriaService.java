package com.br.andsas.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.andsas.domain.Categoria;
import com.br.andsas.repositories.CategoriaRepository;
import com.br.andsas.servicies.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	public Categoria findById(Integer id) {		
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado. Id: " + id + ". Tipo: " + Categoria.class.getName())
		);
	}

}
