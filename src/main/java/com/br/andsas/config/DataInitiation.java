package com.br.andsas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.andsas.domain.Categoria;
import com.br.andsas.domain.Produto;
import com.br.andsas.repositories.CategoriaRepository;
import com.br.andsas.repositories.ProdutoRepository;

@Component
public class DataInitiation {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public void insertValues() {
		
		Categoria categoria1 = new Categoria(
			null, 
			"Informatica"
		);
		Categoria categoria2 = new Categoria(
			null, 
			"Escritorio"
		);
		
		Produto produto1 = new Produto(
			null, 
			"Computador", 
			2000.00
		);
		Produto produto2 = new Produto(
			null, 
			"Impressora", 
			800.00
		);
		Produto produto3 = new Produto(
			null, 
			"Mouse", 
			80.00
		);
		
		categoria1.getProdutos().addAll(Arrays.asList(
			produto1, 
			produto2, 
			produto3
		));
		categoria2.getProdutos().addAll(Arrays.asList(
			produto2
		));
		
		produto1.getCategorias().addAll(Arrays.asList(
			categoria1
		));
		produto2.getCategorias().addAll(Arrays.asList(
			categoria1, 
			categoria2
		));
		produto3.getCategorias().addAll(Arrays.asList(
			categoria1
		));
		
		categoriaRepository.saveAll(Arrays.asList(
			categoria1, 
			categoria2
		));
		produtoRepository.saveAll(Arrays.asList(
			produto1, 
			produto2, 
			produto3
		));

	}

}
