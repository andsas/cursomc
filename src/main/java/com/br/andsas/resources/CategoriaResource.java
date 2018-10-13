package com.br.andsas.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@GetMapping(value="/listar")
	public String listar() {
	return "O REST está funciondo!";
	}

}