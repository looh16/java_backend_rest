package com.backend.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.api.models.Categoria;
import com.backend.api.models.Cidade;
import com.backend.api.models.Cliente;
import com.backend.api.models.Endereco;
import com.backend.api.models.Estado;
import com.backend.api.models.Produto;
import com.backend.api.models.enums.TipoCliente;
import com.backend.api.repositories.CategoriaRepository;
import com.backend.api.repositories.CidadeRepository;
import com.backend.api.repositories.ClienteRepository;
import com.backend.api.repositories.EnderecoRepository;
import com.backend.api.repositories.EstadoRepository;
import com.backend.api.repositories.ProdutoRepository;

@SpringBootApplication
public class JavaBackendApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
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
			
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		List<Estado> estados = new ArrayList<>();
		estados.add(est1);
		estados.add(est2);
		
		Cidade cd1 = new Cidade(null, "Uberlandia", est1);
		Cidade cd2 = new Cidade(null, "Sao Paulo", est2);
		Cidade cd3 = new Cidade(null, "Campinas", est2);
		
		List<Cidade> cidades = new ArrayList<>();
		cidades.add(cd1);
		cidades.add(cd2);
		cidades.add(cd3);
		
		est1.getCidades().add(cd1);
		est2.getCidades().addAll(cidades);
		
		estadoRepository.saveAll(estados);
		cidadeRepository.saveAll(cidades);
		
		Cliente cli1 = new Cliente(null, "Maria Jose", "maria@gmail.com", "550159263565", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().add("9484564545");
		cli1.getTelefones().add("5545465482");
		
		Endereco e1 = new Endereco(null, "Rua flores", "656", "apto 546", "jardim", "646464664", cli1, cd1);
		Endereco e2 = new Endereco(null, "Av.Matos", "568", "sala 111", "centro", "659874133", cli1, cd2);
		
		cli1.getEnderecos().add(e1);
		cli1.getEnderecos().add(e2);
		
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(e1);
		enderecos.add(e2);
		
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(enderecos);

		
	}
}
