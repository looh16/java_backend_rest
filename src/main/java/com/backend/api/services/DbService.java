package com.backend.api.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.api.models.Categoria;
import com.backend.api.models.Cidade;
import com.backend.api.models.Cliente;
import com.backend.api.models.Endereco;
import com.backend.api.models.Estado;
import com.backend.api.models.ItemPedido;
import com.backend.api.models.Pagamento;
import com.backend.api.models.PagamentoComBoleto;
import com.backend.api.models.PagamentoComCartao;
import com.backend.api.models.Pedido;
import com.backend.api.models.Produto;
import com.backend.api.models.enums.EstadoPagamento;
import com.backend.api.models.enums.TipoCliente;
import com.backend.api.repositories.CategoriaRepository;
import com.backend.api.repositories.CidadeRepository;
import com.backend.api.repositories.ClienteRepository;
import com.backend.api.repositories.EnderecoRepository;
import com.backend.api.repositories.EstadoRepository;
import com.backend.api.repositories.ItemPedidoRepository;
import com.backend.api.repositories.PagamentoRepository;
import com.backend.api.repositories.PedidoRepository;
import com.backend.api.repositories.ProdutoRepository;

@Service
public class DbService {

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
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instatieteTestDataBase() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "Fisica");
		Categoria cat3 = new Categoria(null, "mesa");
		Categoria cat4 = new Categoria(null, "fogao");
		Categoria cat5 = new Categoria(null, "cadeira");
		Categoria cat6 = new Categoria(null, "panela");
		Categoria cat7 = new Categoria(null, "papel");
		Categoria cat8 = new Categoria(null, "lapis");
		Categoria cat9 = new Categoria(null, "cabo");
		Categoria cat10 = new Categoria(null, "cadela");
		Categoria cat11 = new Categoria(null, "cao");
		Categoria cat12 = new Categoria(null, "pau");
		Categoria cat13 = new Categoria(null, "garrafa");
		Categoria cat14 = new Categoria(null, "tampa");
		
		Produto p1 = new Produto(null, "computador", 200.000);
		Produto p2 = new Produto(null, "impressora", 40.000);
		Produto p3 = new Produto(null, "mouse", 3.000);
		Produto p4 = new Produto(null, "cadeira", 200.000);
		Produto p5 = new Produto(null, "papel", 40.000);
		Produto p6 = new Produto(null, "fogao", 3.000);
		Produto p7 = new Produto(null, "cama", 200.000);
		Produto p8 = new Produto(null, "impressora", 40.000);
		Produto p9 = new Produto(null, "lapis", 3.000);
		Produto p10 = new Produto(null, "coluna", 200.000);
		Produto p11= new Produto(null, "livro", 40.000);	
		
		
		List<Produto> cat1_p = new ArrayList<>();
		cat1_p.add(p1);
		cat1_p.add(p2);
		cat1_p.add(p3);
		
		List<Produto> cat2_p = new ArrayList<>();
		cat2_p.add(p2);
		cat2_p.add(p4);
		
		List<Produto> cat3_p = new ArrayList<>();
		cat3_p.add(p5);
		cat3_p.add(p6);
		
		List<Produto> cat4_p = new ArrayList<>();
		cat4_p.add(p1);
		cat4_p.add(p2);
		cat4_p.add(p3);
		cat4_p.add(p7);
		
		List<Produto> cat5_p = new ArrayList<>();
		cat5_p.add(p8);
		
		List<Produto> cat6_p = new ArrayList<>();
		cat6_p.add(p9);
		cat6_p.add(p10);
		
		List<Produto> cat7_p = new ArrayList<>();
		cat7_p.add(p11);

		cat1.getProdutos().addAll(cat1_p);
		cat2.getProdutos().addAll(cat2_p);
		cat3.getProdutos().addAll(cat3_p);
		cat4.getProdutos().addAll(cat4_p);
		cat5.getProdutos().addAll(cat5_p);
		cat6.getProdutos().addAll(cat6_p);
		cat7.getProdutos().addAll(cat7_p);
		
		
		p1.getCategorias().add(cat1);
		p1.getCategorias().add(cat4);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat2);
		p2.getCategorias().add(cat4);
		p3.getCategorias().add(cat1);
		p3.getCategorias().add(cat4);
		p4.getCategorias().add(cat2);
		p5.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p7.getCategorias().add(cat4);
		p8.getCategorias().add(cat5);
		p9.getCategorias().add(cat6);
		p10.getCategorias().add(cat6);
		p11.getCategorias().add(cat7);
		
		
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(cat1);
		categorias.add(cat2);
		categorias.add(cat3);
		categorias.add(cat4);
		categorias.add(cat5);
		categorias.add(cat6);
		categorias.add(cat7);
		categorias.add(cat8);
		categorias.add(cat9);
		categorias.add(cat10);
		categorias.add(cat11);
		categorias.add(cat12);
		categorias.add(cat13);
		categorias.add(cat14);
		
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
		produtos.add(p4);
		produtos.add(p5);
		produtos.add(p6);
		produtos.add(p7);
		produtos.add(p8);
		produtos.add(p9);
		produtos.add(p10);
		produtos.add(p11);		
		
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/01/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/05/2017 09:00"), cli1, e2);
		
		List<Pedido> pedidos = new ArrayList<>();
		pedidos.add(ped1);
		pedidos.add(ped2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("30/01/2017 10:32"), null);
		ped2.setPagamento(pagto2);
		
		List<Pagamento> pagamentos = new ArrayList<>();
		pagamentos.add(pagto1);
		pagamentos.add(pagto2);
		
		cli1.getPedidos().addAll(pedidos);
		
		pedidoRepository.saveAll(pedidos);
		pagamentoRepository.saveAll(pagamentos);
		
		ItemPedido ip1 = new ItemPedido(1.2, 200.00, 6, ped1, p1);
		ItemPedido ip2 = new ItemPedido(1.3, 400.00, 1, ped1, p3);
		ItemPedido ip3 = new ItemPedido(1.5, 800.00, 7, ped2, p2);
		
		List<ItemPedido> itemPedidos = new ArrayList<>();
		itemPedidos.add(ip1);
		itemPedidos.add(ip2);
		
		List<ItemPedido> itemSalvarNaBase = new ArrayList<>();
		itemSalvarNaBase.add(ip1);
		itemSalvarNaBase.add(ip2);
		itemSalvarNaBase.add(ip3);
		
		
		ped1.getItens().addAll(itemPedidos);
		ped1.getItens().add(ip3);
		
		p1.getItens().add(ip1);
		p2.getItens().add(ip3);
		p3.getItens().add(ip2);
		
		itemPedidoRepository.saveAll(itemSalvarNaBase);
	}
}
