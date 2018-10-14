package com.br.andsas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.andsas.config.DataInitiation;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private DataInitiation initiation;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initiation.insertValues();
	}
	
}
