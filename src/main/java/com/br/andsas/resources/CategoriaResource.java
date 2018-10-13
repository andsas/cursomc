package com.br.andsas.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.andsas.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@GetMapping
	public List<Categoria> listar() {
		
		List<Categoria> categorias = new ArrayList<>();
		
		categorias.add(new Categoria(1, "Informatica"));
		categorias.add(new Categoria(2, "Eletrodomesticos"));
		categorias.add(new Categoria(3, "Cama, mesa e banho"));
		
		return categorias;
	}

}
