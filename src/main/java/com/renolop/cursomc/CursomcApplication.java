package com.renolop.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renolop.cursomc.domain.Categoria;
import com.renolop.cursomc.domain.Cidade;
import com.renolop.cursomc.domain.Cliente;
import com.renolop.cursomc.domain.Endereco;
import com.renolop.cursomc.domain.Estado;
import com.renolop.cursomc.domain.ItemPedido;
import com.renolop.cursomc.domain.Pagamento;
import com.renolop.cursomc.domain.PagamentoComBoleto;
import com.renolop.cursomc.domain.PagamentoComCartao;
import com.renolop.cursomc.domain.Pedido;
import com.renolop.cursomc.domain.Produto;
import com.renolop.cursomc.domain.enums.EstadoPagamento;
import com.renolop.cursomc.domain.enums.TipoCliente;
import com.renolop.cursomc.repositories.CategoriaRepository;
import com.renolop.cursomc.repositories.CidadeRepository;
import com.renolop.cursomc.repositories.ClienteRepository;
import com.renolop.cursomc.repositories.EnderecoRepository;
import com.renolop.cursomc.repositories.EstadoRepository;
import com.renolop.cursomc.repositories.ItemPedidoRepository;
import com.renolop.cursomc.repositories.PagamentoRepository;
import com.renolop.cursomc.repositories.PedidoRepository;
import com.renolop.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

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

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório" );
		Categoria cat3 = new Categoria(null, "Cama Mesa Banho" );
		Categoria cat4 = new Categoria(null, "Eletrônicos" );
		Categoria cat5 = new Categoria(null, "Jardinagem" );
		Categoria cat6 = new Categoria(null, "Decoração" );
		Categoria cat7 = new Categoria(null, "Casa e Cozinha" );

		Produto p1 = new Produto(null, 2000.00, "Computador");
		Produto p2 = new Produto(null, 800.00, "Impressora");
		Produto p3 = new Produto(null, 80.00, "Mouse");
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll( Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll( Arrays.asList(p1, p2, p3));
		
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Uberlândia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		Cliente cliente1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("32132121", "45645645"));
		
		Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cliente1, cidade1);
		Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cliente1, cidade2);
	
		cliente1.getEnderecos().addAll(Arrays.asList( endereco1, endereco2 ));
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll( Arrays.asList(endereco1, endereco2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		 
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cliente1, endereco1); 
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cliente1, endereco2);    
		 
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6); 
		ped1.setPagamento(pagto1);    
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null); 
		ped2.setPagamento(pagto2); 
		
		cliente1.getPedidos().addAll(Arrays.asList(ped1, ped2)); 
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2)); 
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2)); 
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll( Arrays.asList( ip1, ip2));
		ped2.getItens().addAll( Arrays.asList( ip3));
		
		p1.getItens().addAll( Arrays.asList( ip1));
		p2.getItens().addAll( Arrays.asList( ip3));
		p3.getItens().addAll( Arrays.asList( ip2));

		itemPedidoRepository.saveAll( Arrays.asList(ip1, ip2, ip3 ));
	}
}

