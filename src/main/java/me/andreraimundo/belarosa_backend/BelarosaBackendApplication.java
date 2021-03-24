package me.andreraimundo.belarosa_backend;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import me.andreraimundo.belarosa_backend.domain.Categoria;
import me.andreraimundo.belarosa_backend.domain.Cliente;
import me.andreraimundo.belarosa_backend.domain.Endereco;
import me.andreraimundo.belarosa_backend.domain.ItemPedido;
import me.andreraimundo.belarosa_backend.domain.Pagamento;
import me.andreraimundo.belarosa_backend.domain.PagamentoBoleto;
import me.andreraimundo.belarosa_backend.domain.PagamentoCartao;
import me.andreraimundo.belarosa_backend.domain.PagamentoDinheiro;
import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.domain.Produto;
import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.domain.enums.SituacaoPedido;
import me.andreraimundo.belarosa_backend.repositories.CategoriaRepository;
import me.andreraimundo.belarosa_backend.repositories.ClienteRepository;
import me.andreraimundo.belarosa_backend.repositories.EnderecoRepository;
import me.andreraimundo.belarosa_backend.repositories.ItemPedidoRepository;
import me.andreraimundo.belarosa_backend.repositories.PagamentoRepository;
import me.andreraimundo.belarosa_backend.repositories.PedidoRepository;
import me.andreraimundo.belarosa_backend.repositories.ProdutoRepository;
import me.andreraimundo.belarosa_backend.repositories.RegistroRepository;

@SpringBootApplication
public class BelarosaBackendApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	RegistroRepository registroRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	PagamentoRepository pagamentoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BelarosaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Bolsas");
		Categoria cat2 = new Categoria(null, "Maquiagem");
		
		Produto prod1 = new Produto(null, "CARTEIRA VICTORINE", 279.99);
		Produto prod2 = new Produto(null, "Bolsa Santa Lolla Baú Marrom", 279.99);
		Produto prod3 = new Produto(null, "LES 4 OMBRES QUARTETO DE SOMBRAS MULTIEFEITOS", 199.90);
		Produto prod4 = new Produto(null, "Bolsa Feminina Grande Tote Transversal Couro Ecológico", 89.65);

		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod4));
		cat2.getProdutos().addAll(Arrays.asList(prod3));

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1));
		prod3.getCategorias().addAll(Arrays.asList(cat2));
		prod4.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));

		Cliente cl1 = new Cliente(null, "Lara Ramos", "630.792.070-09", "13/12/1991", "(91)9 88220467");
		Cliente cl2 = new Cliente(null, "Luana Lobato", "867.738.940-77", "24/06/1998", "(91)9 84001327");
		Cliente cl3 = new Cliente(null, "Pamela Lorena", "291.672.410-93", "10/03/1993", "(91)9 99001422");

		Endereco end1 = new Endereco(null, "66123-120", "Passagem Vila Nova", "368", "Sacramenta", "Belém", "PA", cl1);
		Endereco end2 = new Endereco(null, "68655-000", "Rua Coronel Jose Vieira", "38", "Vila Nova", "Irituia", "PA", cl2);
		Endereco end3 = new Endereco(null, "68655-000", "Rua Bom Sossego", "34", "Vila Nova", "Irituia", "PA", cl3);

		cl1.getEnderecos().addAll(Arrays.asList(end1));
		cl2.getEnderecos().addAll(Arrays.asList(end2));
		cl3.getEnderecos().addAll(Arrays.asList(end3));

		clienteRepository.saveAll(Arrays.asList(cl1, cl2, cl3));
		enderecoRepository.saveAll(Arrays.asList(end1, end2,end3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");

		Pedido pedido1 = new Pedido(null, sdf.parse("23/03/2021 22:00"), cl1, end1);
		Pedido pedido2 = new Pedido(null, sdf.parse("22/03/2021 21:00"), cl2, end2);
		Pedido pedido3 = new Pedido(null, sdf.parse("21/03/2021 20:00"), cl3, end3);
		
		Pagamento pgt1 = new PagamentoCartao(null, SituacaoPedido.PENDENTE, pedido1, 10);
		pedido1.setPagamento(pgt1);
		Pagamento pgt2 = new PagamentoBoleto(null, SituacaoPedido.PENDENTE, pedido2, sdf.parse("10/04/2021 23:59"), null);
		pedido2.setPagamento(pgt2);
		Pagamento pgt3 = new PagamentoDinheiro(null,SituacaoPedido.QUITADO, pedido3, 100.00);
		pedido3.setPagamento(pgt3);

		cl1.getPedidos().addAll(Arrays.asList(pedido1));
		cl2.getPedidos().addAll(Arrays.asList(pedido2));
		cl3.getPedidos().addAll(Arrays.asList(pedido3));

		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		pagamentoRepository.saveAll(Arrays.asList(pgt1, pgt2, pgt3));

		ItemPedido itemPedido1 = new ItemPedido(pedido1, prod1, 0.00 , 1, 279.99);
		ItemPedido itemPedido2 = new ItemPedido(pedido2, prod2, 0.00 , 2, 559.98);
		ItemPedido itemPedido3 = new ItemPedido(pedido3, prod3, 0.00 , 3, 387.80);
		ItemPedido itemPedido4 = new ItemPedido(pedido3, prod4, 0.00 , 3, 358.60);

		pedido1.getItens().addAll(Arrays.asList(itemPedido1));
		pedido2.getItens().addAll(Arrays.asList(itemPedido2));
		pedido2.getItens().addAll(Arrays.asList(itemPedido3, itemPedido4));

		prod1.getItens().addAll(Arrays.asList(itemPedido1));
		prod2.getItens().addAll(Arrays.asList(itemPedido2));
		prod3.getItens().addAll(Arrays.asList(itemPedido3));
		prod4.getItens().addAll(Arrays.asList(itemPedido4));

		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3, itemPedido4));

		Registro reg1 = new Registro(null,"9000andre@gmail.com", "admin");
		Registro reg2 = new Registro(null,"andre@gmail.com", "1234");
	
		registroRepository.saveAll(Arrays.asList(reg1, reg2));
	}

}
