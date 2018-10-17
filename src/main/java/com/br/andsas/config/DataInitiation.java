package com.br.andsas.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.andsas.domain.Categoria;
import com.br.andsas.domain.Cidade;
import com.br.andsas.domain.Cliente;
import com.br.andsas.domain.Endereco;
import com.br.andsas.domain.Estado;
import com.br.andsas.domain.Pagamento;
import com.br.andsas.domain.PagamentoComBoleto;
import com.br.andsas.domain.PagamentoComCartao;
import com.br.andsas.domain.Pedido;
import com.br.andsas.domain.Produto;
import com.br.andsas.domain.enuns.EstadoPagamento;
import com.br.andsas.domain.enuns.TipoCliente;
import com.br.andsas.repositories.CategoriaRepository;
import com.br.andsas.repositories.CidadeRepository;
import com.br.andsas.repositories.ClienteRepository;
import com.br.andsas.repositories.EnderecoRepository;
import com.br.andsas.repositories.EstadoRepository;
import com.br.andsas.repositories.PagamentoRepository;
import com.br.andsas.repositories.PedidoRepository;
import com.br.andsas.repositories.ProdutoRepository;

@Component
public class DataInitiation {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public void insertValues() throws ParseException {
		
		/*
		 * Adicionando Categoria e Produto à base de dados
		 * 
		 */

		Categoria categoria1 = new Categoria(null, "Informatica");
		Categoria categoria2 = new Categoria(null, "Escritorio");

		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);		

		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		
		/*
		 * Adicionando Estado e Cidade à base de dados
		 * 
		 */
		
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "Sao Paulo");
		
		Cidade cidade1 = new Cidade(null, "Uberlandia", estado1);
		Cidade cidade2 = new Cidade(null, "Sao Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		/*
		 * Adicionando Cliente e Endereço à base de dados
		 * 
		 */
		
		Cliente cliente1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Ap 303", "Jardim", "38220834", cidade1, cliente1);
		Endereco endereco2 = new Endereco(null, "Av Matos", "105", "Sala 800", "Centro", "38777012", cidade2, cliente1);
		
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
		
		/*
		 * Adicionando Pedido e Pagamento à base de dados
		 * 
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");

		Pedido pedido1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cliente1, endereco1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cliente1, endereco2);
		
		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		Pagamento pagamento1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pagamento1);
		
		Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("20/10/2017 00:00"), null);
		pedido2.setPagamento(pagamento2);		
		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));		

	}

}
