package com.backend.api;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.api.models.Categoria;
import com.backend.api.models.Produto;
import com.backend.api.repositories.CategoriaRepository;
import com.backend.api.repositories.ProdutoRepository;

@SpringBootApplication
public class JavaBackendApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JavaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "Fisica");
		
		Produto p1 = new Produto(null, "computador", 200.000);
		Produto p2 = new Produto(null, "impressora", 40.000);
		Produto p3 = new Produto(null, "mouse", 3.000);
		
		
		List<Produto> cat1_p = new ArrayList<>();
		cat1_p.add(p1);
		cat1_p.add(p2);
		cat1_p.add(p3);
		
		List<Produto> cat2_p = new ArrayList<>();
		cat1_p.add(p2);

		
		cat1.getProdutos().addAll(cat1_p);
		cat2.getProdutos().addAll(cat2_p);
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat2);
		p3.getCategorias().add(cat1);
		
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(cat1);
		categorias.add(cat2);
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
		
		categoriaRepository.saveAll(categorias);
		produtoRepository.saveAll(produtos);
	}
}
