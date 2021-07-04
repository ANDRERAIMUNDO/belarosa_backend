package me.andreraimundo.belarosa_backend.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
import me.andreraimundo.belarosa_backend.domain.enums.Perfil;
import me.andreraimundo.belarosa_backend.repositories.CategoriaRepository;
import me.andreraimundo.belarosa_backend.repositories.ClienteRepository;
import me.andreraimundo.belarosa_backend.repositories.EnderecoRepository;
import me.andreraimundo.belarosa_backend.repositories.ItemPedidoRepository;
import me.andreraimundo.belarosa_backend.repositories.PagamentoRepository;
import me.andreraimundo.belarosa_backend.repositories.PedidoRepository;
import me.andreraimundo.belarosa_backend.repositories.ProdutoRepository;
import me.andreraimundo.belarosa_backend.repositories.RegistroRepository;

@Service
public class DBInitialService {
    
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
	@Autowired
    private BCryptPasswordEncoder pe;

    public void instantiateTestDataBase () throws ParseException {

        Categoria cat1 = new Categoria(null, "Adulto"); 
		Categoria cat2 = new Categoria(null, "Acessorios"); 
		Categoria cat3 = new Categoria(null, "Calçados");
		Categoria cat4 = new Categoria(null, "Bolsas");
		Categoria cat5 = new Categoria(null, "Maquiagens");
		Categoria cat6 = new Categoria(null, "Oculos");
		Categoria cat7 = new Categoria(null, "Roupas");
		Categoria cat8 = new Categoria(null, "Utensilios");
		
		Produto prod1 = new Produto(null, "CARTEIRA VICTORINE", 279.99);
		Produto prod2 = new Produto(null, "Bolsa Santa Lolla Baú Marrom", 279.99);
		Produto prod3 = new Produto(null, "LES 4 OMBRES QUARTETO DE SOMBRAS MULTIEFEITOS", 199.90);
		Produto prod4 = new Produto(null, "Bolsa Feminina Grande Tote Transversal Couro Ecológico", 89.65);
		Produto prod5 = new Produto(null, "Bolsa + Sapato Feminino Coleção Verão", 99.99);
		Produto prod6 = new Produto(null, "Produto 1", 99.99);
		Produto prod7 = new Produto(null, "Produto 2", 99.99);
		Produto prod8 = new Produto(null, "Produto 3", 99.99);
		Produto prod9 = new Produto(null, "Produto 4", 99.99);
		Produto prod10 = new Produto(null, "Produto 5", 99.99);
		Produto prod11 = new Produto(null, "Produto 6", 99.99);
		Produto prod12 = new Produto(null, "Produto 7", 99.99);
		Produto prod13 = new Produto(null, "Produto 8", 99.99);
		Produto prod14 = new Produto(null, "Produto 9", 99.99);
		Produto prod15 = new Produto(null, "Produto 10", 99.99);
		Produto prod16 = new Produto(null, "Produto 11", 99.99);
		Produto prod17 = new Produto(null, "Produto 12", 99.99);
		Produto prod18 = new Produto(null, "Produto 13", 99.99);
		Produto prod19 = new Produto(null, "Produto 14", 99.99);
		Produto prod20 = new Produto(null, "Produto 15", 99.99);
		Produto prod21 = new Produto(null, "Produto 16", 99.99);
		Produto prod22 = new Produto(null, "Produto 17", 99.99);		
		Produto prod23 = new Produto(null, "Produto 18", 99.99);
		Produto prod24 = new Produto(null, "Produto 19", 99.99);
		Produto prod25 = new Produto(null, "Produto 20", 99.99);
		Produto prod26 = new Produto(null, "Produto 21", 99.99);
		Produto prod27 = new Produto(null, "Fantazia Noturna Dracula", 129.90);
		Produto prod28 = new Produto(null, "Rabo de gato", 9.90);
		Produto prod29 = new Produto(null, "Tapa olho do pirata", 7.00);

		cat1.getProdutos().addAll(Arrays.asList(prod27, prod28, prod29));
		cat3.getProdutos().addAll(Arrays.asList(prod5));
		cat4.getProdutos().addAll(Arrays.asList(prod1, prod2, prod4, prod5));
		cat5.getProdutos().addAll(Arrays.asList(prod3, prod5, prod6, prod7, prod8, prod9,prod10, prod11, prod12, prod13, prod14, prod15, prod16, prod17, prod18, prod19, prod20, prod21, prod22, prod23, prod24, prod25, prod26));

		prod1.getCategorias().addAll(Arrays.asList(cat4));
		prod2.getCategorias().addAll(Arrays.asList(cat4));
		prod3.getCategorias().addAll(Arrays.asList(cat5));
		prod4.getCategorias().addAll(Arrays.asList(cat4));
		prod5.getCategorias().addAll(Arrays.asList(cat3, cat4));
		prod6.getCategorias().addAll(Arrays.asList(cat5));
		prod7.getCategorias().addAll(Arrays.asList(cat5));
		prod8.getCategorias().addAll(Arrays.asList(cat5));
		prod9.getCategorias().addAll(Arrays.asList(cat5));
		prod10.getCategorias().addAll(Arrays.asList(cat5));
		prod11.getCategorias().addAll(Arrays.asList(cat5));
		prod12.getCategorias().addAll(Arrays.asList(cat5));
		prod13.getCategorias().addAll(Arrays.asList(cat5));
		prod14.getCategorias().addAll(Arrays.asList(cat5));
		prod15.getCategorias().addAll(Arrays.asList(cat5));
		prod16.getCategorias().addAll(Arrays.asList(cat5));
		prod17.getCategorias().addAll(Arrays.asList(cat5));
		prod18.getCategorias().addAll(Arrays.asList(cat5));
		prod19.getCategorias().addAll(Arrays.asList(cat5));
		prod20.getCategorias().addAll(Arrays.asList(cat5));
		prod21.getCategorias().addAll(Arrays.asList(cat5));
		prod22.getCategorias().addAll(Arrays.asList(cat5));
		prod23.getCategorias().addAll(Arrays.asList(cat5));
		prod24.getCategorias().addAll(Arrays.asList(cat5));
		prod25.getCategorias().addAll(Arrays.asList(cat5));
		prod26.getCategorias().addAll(Arrays.asList(cat5));
		prod27.getCategorias().addAll(Arrays.asList(cat1));
		prod28.getCategorias().addAll(Arrays.asList(cat1));
		prod29.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8,prod9, prod10, prod11, prod12, prod13, prod14, prod15, prod16, prod17, prod18, prod19, prod20, prod21, prod22, prod23,prod24, prod25, prod26,prod27,prod28, prod29));

		Registro reg1 = new Registro(null, "andreraimundoo@hotmail.com", pe.encode("1234"));
		Registro reg2 = new Registro(null, "luanalobato@gmail.com", pe.encode("1234"));
		Registro reg3 = new Registro(null, "pamelalorena@gmail.com", pe.encode("1234"));
		reg3.addPerfil(Perfil.ADMIN); 

		Cliente cl1 = new Cliente(reg1, null, "Andre Raimundo", "630.792.070-09", "13/12/2009", "(91)9 88220467");
		Cliente cl2 = new Cliente(reg2,null, "Luana Lobato", "867.738.940-77", "24/06/1993", "(91)9 84001327");
		Cliente cl3 = new Cliente(reg3, null, "Pamela Lorena", "291.672.410-93", "10/03/1991", "(91)9 99001422");


		registroRepository.saveAll(Arrays.asList(reg1, reg2, reg3));
		clienteRepository.saveAll(Arrays.asList(cl1, cl2, cl3));

		Endereco end1 = new Endereco(null, "68655-000", "Rua Coronel Joao Cancio","20", "Comercio", "Centro", "Irituia", "PA",reg1, cl1);
		Endereco end2 = new Endereco(null, "68655-000", "Rua Coronel Jose Vieira", "38", "centro", "Vila Nova", "Irituia", "PA",reg2, cl2);
		Endereco end3 = new Endereco(null, "68655-000", "Rua Bom Sossego", "34", "centro","Vila Nova", "Irituia", "PA",reg3, cl3);

		cl1.getEnderecos().addAll(Arrays.asList(end1));
		cl2.getEnderecos().addAll(Arrays.asList(end2));
		cl3.getEnderecos().addAll(Arrays.asList(end3));		

		
		enderecoRepository.saveAll(Arrays.asList(end1, end2,end3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");

		Pedido pedido1 = new Pedido(null, sdf.parse("23/03/2021 22:00"), reg1, cl1, end1);
		Pedido pedido2 = new Pedido(null, sdf.parse("22/03/2021 21:00"), reg2, cl2, end2);
		Pedido pedido3 = new Pedido(null, sdf.parse("21/03/2021 20:00"), reg3, cl3, end3);
		
		Pagamento pgt1 = new PagamentoCartao(null, SituacaoPedido.PENDENTE, pedido1, 10);
		pedido1.setPagamento(pgt1);
		Pagamento pgt2 = new PagamentoBoleto(null, SituacaoPedido.PENDENTE, pedido2, sdf.parse("10/04/2021 23:59"), null);
		pedido2.setPagamento(pgt2);
		Pagamento pgt3 = new PagamentoDinheiro(null, SituacaoPedido.QUITADO, pedido3, sdf.parse("21/03/2021 20:00"));
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

    }
    
}
