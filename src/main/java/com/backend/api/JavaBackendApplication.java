package com.backend.api;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.api.models.Categoria;
import com.backend.api.repositories.CategoriaRepository;

@SpringBootApplication
public class JavaBackendApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JavaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "Fisica");
		
		List<Categoria> todas = new ArrayList<>();
		todas.add(cat1);
		todas.add(cat2);
		
		categoriaRepository.saveAll(todas);
	}
}
