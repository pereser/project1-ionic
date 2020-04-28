package com.rodrigocod.unidonate;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rodrigocod.unidonate.domain.Categoria;
import com.rodrigocod.unidonate.domain.Cidade;
import com.rodrigocod.unidonate.domain.Cliente;
import com.rodrigocod.unidonate.domain.Endereco;
import com.rodrigocod.unidonate.domain.Estado;
import com.rodrigocod.unidonate.domain.ItemPedido;
import com.rodrigocod.unidonate.domain.Pagamento;
import com.rodrigocod.unidonate.domain.PagamentoComBoleto;
import com.rodrigocod.unidonate.domain.PagamentoComCartao;
import com.rodrigocod.unidonate.domain.Pedido;
import com.rodrigocod.unidonate.domain.Produto;
import com.rodrigocod.unidonate.domain.enums.EstadoPagamento;
import com.rodrigocod.unidonate.domain.enums.TipoCliente;
import com.rodrigocod.unidonate.repositories.CategoriaRepository;
import com.rodrigocod.unidonate.repositories.CidadeRepository;
import com.rodrigocod.unidonate.repositories.ClienteRepository;
import com.rodrigocod.unidonate.repositories.EnderecoRepository;
import com.rodrigocod.unidonate.repositories.EstadoRepository;
import com.rodrigocod.unidonate.repositories.ItemPedidoRepository;
import com.rodrigocod.unidonate.repositories.PagamentoRepository;
import com.rodrigocod.unidonate.repositories.PedidoRepository;
import com.rodrigocod.unidonate.repositories.ProdutoRepository;

@SpringBootApplication
public class UnidonateApplication implements CommandLineRunner {
	
	
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
		SpringApplication.run(UnidonateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Alimentos");
		Categoria cat2 = new Categoria(null, "Bebidas");
		
		Produto p1 = new Produto(null, "Feijao", 2.00);
		Produto p2 = new Produto(null, "Arroz", 8.00);
		Produto p3 = new Produto(null, "Tomate", 1.20);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2 ,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));	
	
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria", "Joanadark@gmail.com", "149382830493", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("2929392393", "203020302"));
		
		Endereco e1 = new Endereco(null, "Rua fires", "200", "Casa", "guararapes", "2923992", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua fireses", "2003", "Casa", "guararapes", "29233992", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32") , cli1 , e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/03/2012 03:32") , cli1 , e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2 , sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1 , 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2 , 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1 , 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}

}
