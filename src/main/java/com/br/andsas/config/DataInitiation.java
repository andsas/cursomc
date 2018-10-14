package com.br.andsas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.andsas.domain.Categoria;
import com.br.andsas.repositories.CategoriaRepository;

@Component
public class DataInitiation {
	
	@Autowired
	private CategoriaRepository repository;

	public void insertValues() {
		
		repository.saveAll(Arrays.asList(
			new Categoria(null, "Informatica"),
			new Categoria(null, "Escritorio"),
			new Categoria(null, "Cosmeticos"),
			new Categoria(null, "Brinquedos"),
			new Categoria(null, "PetShoop")
		));
		
	}

}
