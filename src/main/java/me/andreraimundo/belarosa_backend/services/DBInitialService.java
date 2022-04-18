package me.andreraimundo.belarosa_backend.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Categoria;
import me.andreraimundo.belarosa_backend.domain.Cliente;
import me.andreraimundo.belarosa_backend.domain.Descricao;
import me.andreraimundo.belarosa_backend.domain.Endereco;
import me.andreraimundo.belarosa_backend.domain.ItemPedido;
import me.andreraimundo.belarosa_backend.domain.Pagamento;
import me.andreraimundo.belarosa_backend.domain.PagamentoBoleto;
import me.andreraimundo.belarosa_backend.domain.PagamentoCartao;
import me.andreraimundo.belarosa_backend.domain.PagamentoDinheiro;
import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.domain.Produto;
import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.domain.ReservaDePedido;
import me.andreraimundo.belarosa_backend.domain.enums.SituacaoPedido;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PayerUser;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PixApplicationData;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PixPayment;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PixPointOfInteraction;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PixTransactionData;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PixTransactionDetails;
import me.andreraimundo.belarosa_backend.dto.mercadopago.ProcessPayment;
import me.andreraimundo.belarosa_backend.dto.mercadopago.StatusPayment;
import me.andreraimundo.belarosa_backend.domain.enums.Perfil;
import me.andreraimundo.belarosa_backend.repositories.CategoriaRepository;
import me.andreraimundo.belarosa_backend.repositories.ClienteRepository;
import me.andreraimundo.belarosa_backend.repositories.DescricaoRepository;
import me.andreraimundo.belarosa_backend.repositories.EnderecoRepository;
import me.andreraimundo.belarosa_backend.repositories.ItemPedidoRepository;
import me.andreraimundo.belarosa_backend.repositories.PagamentoRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.PayerUserRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.PixApplicationDataRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.PixPaymentRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.PixPointOfInteractionRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.PixTransactionDataRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.PixTransactionDetailsRepository;
import me.andreraimundo.belarosa_backend.repositories.PedidoRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.ProcessPaymentRepository;
import me.andreraimundo.belarosa_backend.repositories.ProdutoRepository;
import me.andreraimundo.belarosa_backend.repositories.RegistroRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.StatusPaymentRepository;

@Service
public class DBInitialService {
    
    @Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	DescricaoRepository descricaoRepository;
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
	ProcessPaymentRepository processPaymentRepository;
	@Autowired
    private StatusPaymentRepository statusPaymentRepository;
	@Autowired
	private PixApplicationDataRepository pixApplicationDataRepository;
	@Autowired
	private PixPaymentRepository  pixPaymentRepository;
	@Autowired
	private PixPointOfInteractionRepository pixPointOfInteractionRepository;
	@Autowired
	private PixTransactionDataRepository pixTransactionDataRepository;
	@Autowired
	private PixTransactionDetailsRepository pixTransactionDetailsRepository;

	@Autowired
	PayerUserRepository payerRepository;
	@Autowired
    private BCryptPasswordEncoder pe;

    public void instantiateTestDataBase () throws ParseException {

		Descricao descr1 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr2 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr3 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr4 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr5 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr6 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr7 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr8 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr9 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr10 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr11 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr12 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr13 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr14 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr15 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr16 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr17 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr18 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr19 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr20 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr21 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr22 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr23 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr24 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr25 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr26 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr27 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr28 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr29 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		Descricao descr30 = new Descricao(null, "Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ");
		
		Categoria cat1 = new Categoria(null, "Adulto"); 
		Categoria cat2 = new Categoria(null, "Acessorios"); 
		Categoria cat3 = new Categoria(null, "Calçados");
		Categoria cat4 = new Categoria(null, "Bolsas");
		Categoria cat5 = new Categoria(null, "Maquiagens");
		Categoria cat6 = new Categoria(null, "Oculos");
		Categoria cat7 = new Categoria(null, "Roupas");
		Categoria cat8 = new Categoria(null, "Utensilios");

		Produto prod1 = new Produto(null, "Carteita victorino em couro", 0.0);
		Produto prod2 = new Produto(null, "Bolsa Santa Lolla Baú Marrom", 279.99);
		Produto prod3 = new Produto(null, "Les Sombra quarteto multiefeitos", 199.90);
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
		Produto prod28 = new Produto(null, "Rabo de gato", 10.00);
		Produto prod29 = new Produto(null, "Tapa olho do pirata", 7.00);
		Produto prod30 = new Produto(null, "Oculos bifocal dia", 90.00);

		prod1.getDescricoes().addAll(Arrays.asList(descr1));
		prod2.getDescricoes().addAll(Arrays.asList(descr2));
		prod3.getDescricoes().addAll(Arrays.asList(descr3));
		prod4.getDescricoes().addAll(Arrays.asList(descr4));
		prod5.getDescricoes().addAll(Arrays.asList(descr5));
		prod6.getDescricoes().addAll(Arrays.asList(descr6));
		prod7.getDescricoes().addAll(Arrays.asList(descr7));
		prod8.getDescricoes().addAll(Arrays.asList(descr8));
		prod9.getDescricoes().addAll(Arrays.asList(descr9));
		prod10.getDescricoes().addAll(Arrays.asList(descr10));
		prod11.getDescricoes().addAll(Arrays.asList(descr11));
		prod12.getDescricoes().addAll(Arrays.asList(descr12));
		prod13.getDescricoes().addAll(Arrays.asList(descr13));
		prod14.getDescricoes().addAll(Arrays.asList(descr14));
		prod15.getDescricoes().addAll(Arrays.asList(descr15));
		prod16.getDescricoes().addAll(Arrays.asList(descr16));
		prod17.getDescricoes().addAll(Arrays.asList(descr17));
		prod18.getDescricoes().addAll(Arrays.asList(descr18));
		prod19.getDescricoes().addAll(Arrays.asList(descr19));
		prod20.getDescricoes().addAll(Arrays.asList(descr20));
		prod21.getDescricoes().addAll(Arrays.asList(descr21));
		prod22.getDescricoes().addAll(Arrays.asList(descr22));
		prod23.getDescricoes().addAll(Arrays.asList(descr23));
		prod24.getDescricoes().addAll(Arrays.asList(descr24));
		prod25.getDescricoes().addAll(Arrays.asList(descr25));
		prod26.getDescricoes().addAll(Arrays.asList(descr26));
		prod27.getDescricoes().addAll(Arrays.asList(descr27));
		prod28.getDescricoes().addAll(Arrays.asList(descr28));
		prod29.getDescricoes().addAll(Arrays.asList(descr29));
		prod30.getDescricoes().addAll(Arrays.asList(descr30));

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
		prod30.getCategorias().addAll(Arrays.asList(cat4));

		descr1.getProdutos().addAll(Arrays.asList(prod1));
		descr2.getProdutos().addAll(Arrays.asList(prod2));
		descr3.getProdutos().addAll(Arrays.asList(prod3));
		descr4.getProdutos().addAll(Arrays.asList(prod4));
		descr5.getProdutos().addAll(Arrays.asList(prod5));
		descr6.getProdutos().addAll(Arrays.asList(prod6));
		descr7.getProdutos().addAll(Arrays.asList(prod7));
		descr8.getProdutos().addAll(Arrays.asList(prod8));
		descr9.getProdutos().addAll(Arrays.asList(prod9));
		descr10.getProdutos().addAll(Arrays.asList(prod10));
		descr11.getProdutos().addAll(Arrays.asList(prod11));
		descr12.getProdutos().addAll(Arrays.asList(prod12));
		descr13.getProdutos().addAll(Arrays.asList(prod13));
		descr14.getProdutos().addAll(Arrays.asList(prod14));
		descr15.getProdutos().addAll(Arrays.asList(prod15));
		descr16.getProdutos().addAll(Arrays.asList(prod16));
		descr17.getProdutos().addAll(Arrays.asList(prod17));
		descr18.getProdutos().addAll(Arrays.asList(prod18));
		descr19.getProdutos().addAll(Arrays.asList(prod19));
		descr20.getProdutos().addAll(Arrays.asList(prod20));
		descr21.getProdutos().addAll(Arrays.asList(prod21));
		descr22.getProdutos().addAll(Arrays.asList(prod22));
		descr23.getProdutos().addAll(Arrays.asList(prod23));
		descr24.getProdutos().addAll(Arrays.asList(prod24));
		descr25.getProdutos().addAll(Arrays.asList(prod25));
		descr26.getProdutos().addAll(Arrays.asList(prod26));
		descr27.getProdutos().addAll(Arrays.asList(prod27));
		descr28.getProdutos().addAll(Arrays.asList(prod28));
		descr29.getProdutos().addAll(Arrays.asList(prod29));
		descr30.getProdutos().addAll(Arrays.asList(prod30));

		cat1.getProdutos().addAll(Arrays.asList(prod27, prod28, prod29));
		cat3.getProdutos().addAll(Arrays.asList(prod5));
		cat4.getProdutos().addAll(Arrays.asList(prod1, prod2, prod4, prod5));
		cat5.getProdutos().addAll(Arrays.asList(prod3, prod5, prod6, prod7, prod8, prod9,prod10, prod11, prod12, prod13, prod14, prod15, prod16, prod17, prod18, prod19, prod20, prod21, prod22, prod23, prod24, prod25, prod26));
		cat6.getProdutos().addAll(Arrays.asList(prod30));
		
		descricaoRepository.saveAll(Arrays.asList(descr1, descr2, descr3, descr4, descr5, descr6, descr7, descr8, descr9, descr10, descr11, descr12, descr13, descr14, descr15, descr16, descr17, descr18, descr19, descr20, descr21, descr22, descr23, descr24, descr25, descr26, descr27, descr28, descr29, descr30));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8,prod9, prod10, prod11, prod12, prod13, prod14, prod15, prod16, prod17, prod18, prod19, prod20, prod21, prod22, prod23,prod24, prod25, prod26,prod27,prod28, prod29, prod30));
		
		Registro reg1 = new Registro (null, "9000andre@gmail.com", pe.encode("1402"));
		reg1.addPerfil(Perfil.ADMIN); 
		Registro reg2 = new Registro (null, "andrefake@gmail.com", pe.encode("1402"));
		Registro reg3 = new Registro (null, "gizelamgro@gmail.com", pe.encode("1402"));
		reg3.addPerfil(Perfil.ADMIN);
		Registro reg4 = new Registro (null, "robertolcm92@gmail.com", pe.encode("1402"));
		reg4.addPerfil(Perfil.ADMIN);
		Registro reg5 = new Registro (null, "terezinhajro@gmail.com", pe.encode("1402"));
		reg5.addPerfil(Perfil.ADMIN);
		Registro reg6 = new Registro (null, "test_user_3815517@testuser.com", pe.encode("qatest2132"));
		Registro reg7 = new Registro (null, "andreraimundoo@hotmail.com", pe.encode("1402"));
		
		Cliente cl1 = new Cliente(reg1, null, "Andre Raimundo Rodrigues de Oliveira", "86773894077", "24061993", "91984001327");
		Cliente cl2 = new Cliente(reg2, null, "Andre Fake User", "63079207009", "30111991", "91987567180");
		Cliente cl3 = new Cliente(reg3, null, "Gisela Rodrigues de Oliveira", "29167241093", "10031991", "91999001422");
		Cliente cl4 = new Cliente(reg4, null, "Roberto Luiz Cabral Moraes", "01011990","82640149253", "91999132862");
		Cliente cl5 = new Cliente(reg5, null, "Terezinha de Oliveira", "63079207009", "13122009", "91988646337");
		Cliente cl6 = new Cliente(reg6, null, "TESTYPLFCXOQ", "11111111111", "30/11/1998", "91987654472");
		Cliente cl7 = new Cliente(reg7, null, "Andre Raimundoo Oliveira", "22501422031", "30/11/1998", "91987654472");

		registroRepository.saveAll(Arrays.asList(reg1, reg2, reg3, reg4, reg5, reg6, reg7));
		clienteRepository.saveAll(Arrays.asList(cl1, cl2, cl3, cl4, cl5, cl6, cl7));

		Endereco end1 = new Endereco(null, "68655000", "Rua Coronel Joao Cancio","20", "Comercio", "Centro", "Irituia", "PA",reg1, cl1);
		Endereco end2 = new Endereco(null, "68655000", "Rua Coronel Jose Vieira", "38", "centro", "Vila Nova", "Irituia", "PA",reg2, cl2);
		Endereco end3 = new Endereco(null, "68655000", "Rua Bom Sossego", "34", "centro","Vila Nova", "Irituia", "PA",reg3, cl3);
		Endereco end4 = new Endereco(null, "68655000", "Rua Coronel Jose Vieira", "38", "centro","Vila Nova", "Irituia", "PA",reg4, cl4);
		Endereco end5 = new Endereco(null, "68655000", "Rua Coronel Jose Vieira", "38", "centro", "Vila Nova", "Irituia", "PA",reg5, cl5);
		Endereco end6 = new Endereco(null, "68655000", "Rua Coronel Joao Cancio","20", "Comercio", "Centro", "Irituia", "PA",reg6, cl6);
		Endereco end7 = new Endereco(null, "68655000", "Rua Coronel Joao Cancio","20", "Comercio", "Centro", "Irituia", "PA",reg7, cl7);

		cl1.getEnderecos().addAll(Arrays.asList(end1));
		cl2.getEnderecos().addAll(Arrays.asList(end2));
		cl3.getEnderecos().addAll(Arrays.asList(end3));	
		cl4.getEnderecos().addAll(Arrays.asList(end4));
		cl5.getEnderecos().addAll(Arrays.asList(end5));		
		cl6.getEnderecos().addAll(Arrays.asList(end6));
		cl7.getEnderecos().addAll(Arrays.asList(end7));		

		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4, end5, end6, end7));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		
		Pedido pedido1 = new Pedido(null, sdf.parse("23/03/2021 22:00"), reg7, cl7, end7, null);
		Pedido pedido2 = new Pedido(null, sdf.parse("22/03/2021 21:00"), reg7, cl7, end7, null);
		Pedido pedido3 = new Pedido(null, sdf.parse("21/03/2021 20:00"), reg7, cl7, end7, null);
		Pedido pedido4 = new Pedido(null, sdf.parse("03/01/2021 22:00"), reg7, cl7, end7, null);
		Pedido pedido5 = new Pedido(null, sdf.parse("22/01/2021 21:00"), reg7, cl7, end7, null);
		Pedido pedido6 = new Pedido(null, sdf.parse("27/01/2021 20:00"), reg7, cl7, end7, null);
		Pedido pedido7 = new Pedido(null, sdf.parse("12/03/2021 22:00"), reg7, cl7, end7, null);
		Pedido pedido8 = new Pedido(null, sdf.parse("20/06/2021 21:00"), reg7, cl7, end7, null);
		Pedido pedido9 = new Pedido(null, sdf.parse("14/07/2021 20:00"), reg7, cl7, end7, null);
		Pedido pedido10 = new Pedido(null, sdf.parse("23/07/2021 22:00"), reg7, cl7, end7, null);
		Pedido pedido11 = new Pedido(null, sdf.parse("30/07/2021 21:00"), reg7, cl7, end7, null);
		Pedido pedido12 = new Pedido(null, sdf.parse("01/08/2021 20:00"), reg7, cl7, end7, null);
		Pedido pedido13 = new Pedido(null, sdf.parse("06/08/2021 22:00"), reg7, cl7, end7, null);
		Pedido pedido14 = new Pedido(null, sdf.parse("12/08/2021 21:00"), reg7, cl7, end7, null);
		Pedido pedido15 = new Pedido(null, sdf.parse("27/08/2021 20:00"), reg6, cl6, end6, null);
		
		Pagamento pgt1 = new PagamentoCartao(null, SituacaoPedido.PENDENTE, pedido1, 10);
		pedido1.setPagamento(pgt1);
		Pagamento pgt2 = new PagamentoBoleto(null, SituacaoPedido.PENDENTE, pedido2, sdf.parse("10/04/2021 23:59"), null);
		pedido2.setPagamento(pgt2);
		Pagamento pgt3 = new ReservaDePedido (null, SituacaoPedido.QUITADO, pedido3, sdf.parse("21/03/2021 20:00"), "Retirar na loja");
		pedido3.setPagamento(pgt3);
		Pagamento pgt4 = new PagamentoCartao(null, SituacaoPedido.QUITADO, pedido4, 4);
		pedido4.setPagamento(pgt4);
		Pagamento pgt5 = new PagamentoDinheiro(null, SituacaoPedido.QUITADO, pedido5, sdf.parse("22/01/2021 21:00"));
		pedido5.setPagamento(pgt5);
		Pagamento pgt6 = new PagamentoDinheiro(null, SituacaoPedido.QUITADO, pedido6, sdf.parse("21/03/2021 20:00"));
		pedido6.setPagamento(pgt6);
		Pagamento pgt7 = new PagamentoDinheiro(null, SituacaoPedido.QUITADO, pedido7, sdf.parse("12/03/2021 22:00"));
		pedido7.setPagamento(pgt7);
		Pagamento pgt8 = new PagamentoDinheiro(null, SituacaoPedido.QUITADO, pedido8, sdf.parse("20/06/2021 21:00"));
		pedido8.setPagamento(pgt8);
		Pagamento pgt9 = new PagamentoDinheiro(null, SituacaoPedido.QUITADO, pedido9, sdf.parse("14/07/2021 20:00"));
		pedido9.setPagamento(pgt9);
		Pagamento pgt10 = new PagamentoDinheiro(null, SituacaoPedido.QUITADO, pedido10, sdf.parse("23/07/2021 22:00"));
		pedido10.setPagamento(pgt10);
		Pagamento pgt11 = new PagamentoDinheiro(null, SituacaoPedido.QUITADO, pedido11, sdf.parse("30/07/2021 21:00"));
		pedido11.setPagamento(pgt11);
		Pagamento pgt12 = new PagamentoDinheiro(null, SituacaoPedido.QUITADO, pedido12, sdf.parse("01/08/2021 20:00"));
		pedido12.setPagamento(pgt12);
		Pagamento pgt13 = new PagamentoDinheiro(null, SituacaoPedido.QUITADO, pedido13, sdf.parse("06/08/2021 22:00"));
		pedido13.setPagamento(pgt13);
		Pagamento pgt14 = new PagamentoDinheiro(null, SituacaoPedido.QUITADO, pedido14, sdf.parse("12/08/2021 21:00"));
		pedido14.setPagamento(pgt14);
		Pagamento pgt15 = new PagamentoDinheiro(null, SituacaoPedido.QUITADO, pedido15, sdf.parse("27/08/2021 20:00"));
		pedido15.setPagamento(pgt15);

		cl2.getPedidos().addAll(Arrays.asList(pedido1, pedido2, pedido3, pedido4, pedido5, pedido6, pedido7, pedido8, pedido9, pedido10, pedido11, pedido12, pedido13, pedido14, pedido15));

		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3, pedido4, pedido5, pedido6, pedido7, pedido8, pedido9, pedido10, pedido11, pedido12, pedido13, pedido14, pedido15));
		pagamentoRepository.saveAll(Arrays.asList(pgt1, pgt2, pgt3));

		ItemPedido itemPedido1 = new ItemPedido(pedido1, prod1, 0.00 , 1, 279.99);
		ItemPedido itemPedido2 = new ItemPedido(pedido2, prod2, 0.00 , 2, 559.98);
		ItemPedido itemPedido3 = new ItemPedido(pedido3, prod3, 0.00 , 3, 387.80);
		ItemPedido itemPedido4 = new ItemPedido(pedido4, prod4, 0.00 , 3, 358.60);
		ItemPedido itemPedido5 = new ItemPedido(pedido5, prod5, 0.00 , 1, 99.99);
		ItemPedido itemPedido6 = new ItemPedido(pedido6, prod6, 0.00 , 1, 99.99);
		ItemPedido itemPedido7 = new ItemPedido(pedido7, prod7, 0.00 , 1, 99.99);
		ItemPedido itemPedido8 = new ItemPedido(pedido8, prod8, 0.00 , 1, 99.99);
		ItemPedido itemPedido9 = new ItemPedido(pedido9, prod9, 0.00 , 1, 99.99);
		ItemPedido itemPedido10 = new ItemPedido(pedido10, prod10, 0.00 , 1, 99.99);
		ItemPedido itemPedido11 = new ItemPedido(pedido11, prod11, 0.00 , 1, 99.99);
		ItemPedido itemPedido12 = new ItemPedido(pedido12, prod12, 0.00 , 1, 99.99);
		ItemPedido itemPedido13 = new ItemPedido(pedido13, prod13, 0.00 , 1, 99.99);
		ItemPedido itemPedido14 = new ItemPedido(pedido14, prod14, 0.00 , 1, 99.99);
		ItemPedido itemPedido15 = new ItemPedido(pedido15, prod15, 0.00 , 1, 99.99);

		pedido1.getItens().addAll(Arrays.asList(itemPedido1));
		pedido2.getItens().addAll(Arrays.asList(itemPedido2));
		pedido2.getItens().addAll(Arrays.asList(itemPedido3, itemPedido4));
		pedido5.getItens().addAll(Arrays.asList(itemPedido5));
		pedido6.getItens().addAll(Arrays.asList(itemPedido6));
		pedido7.getItens().addAll(Arrays.asList(itemPedido7));
		pedido8.getItens().addAll(Arrays.asList(itemPedido8));
		pedido9.getItens().addAll(Arrays.asList(itemPedido9));
		pedido10.getItens().addAll(Arrays.asList(itemPedido10));
		pedido11.getItens().addAll(Arrays.asList(itemPedido11));
		pedido12.getItens().addAll(Arrays.asList(itemPedido12));
		pedido13.getItens().addAll(Arrays.asList(itemPedido13));
		pedido14.getItens().addAll(Arrays.asList(itemPedido14));
		pedido15.getItens().addAll(Arrays.asList(itemPedido15));

		prod1.getItens().addAll(Arrays.asList(itemPedido1));
		prod2.getItens().addAll(Arrays.asList(itemPedido2));
		prod3.getItens().addAll(Arrays.asList(itemPedido3));
		prod4.getItens().addAll(Arrays.asList(itemPedido4));
		prod5.getItens().addAll(Arrays.asList(itemPedido5));
		prod6.getItens().addAll(Arrays.asList(itemPedido6));
		prod7.getItens().addAll(Arrays.asList(itemPedido7));
		prod8.getItens().addAll(Arrays.asList(itemPedido8));
		prod9.getItens().addAll(Arrays.asList(itemPedido9));
		prod10.getItens().addAll(Arrays.asList(itemPedido10));
		prod11.getItens().addAll(Arrays.asList(itemPedido11));
		prod12.getItens().addAll(Arrays.asList(itemPedido12));
		prod13.getItens().addAll(Arrays.asList(itemPedido13));
		prod14.getItens().addAll(Arrays.asList(itemPedido14));
		prod15.getItens().addAll(Arrays.asList(itemPedido15));

		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3, itemPedido4, itemPedido5, itemPedido6, itemPedido7, itemPedido8, itemPedido9, itemPedido10, itemPedido11, itemPedido12, itemPedido13, itemPedido14, itemPedido15));
	

		//mercado pago
		ProcessPayment pp1 = new ProcessPayment(null, 99.99, "ae806f1f4ede27b833a843805a375b81", "pagamento com cartao master", 1, "master", 24);
		processPaymentRepository.saveAll(Arrays.asList(pp1));

		PayerUser pay1 = new PayerUser(null, "test_user_3815517@testuser.com", pp1);
		pp1.getPayers().addAll(Arrays.asList(pay1));

		payerRepository.saveAll(Arrays.asList(pay1));

		StatusPayment stp1 = new StatusPayment(reg6, pp1, null, "1212122", "aproved", "payment aproved", "master", "credit card", sdf.parse(("27/08/2021 20:00")));
		statusPaymentRepository.saveAll(Arrays.asList(stp1));

		PixPayment pxp1 = new PixPayment(reg6, null, "5466317", "pending", "pending_waiting_transfer");

		PixTransactionDetails ptdl1 = new PixTransactionDetails(null, 0.0, 10.00, 0.0, "linkpix", 2.0, "mp", pxp1);
		PixPointOfInteraction ppi1 = new PixPointOfInteraction(null, "PIX", null, pxp1);

		pixPaymentRepository.saveAll(Arrays.asList(pxp1));
		pixTransactionDetailsRepository.saveAll(Arrays.asList(ptdl1));
		pixPointOfInteractionRepository.saveAll(Arrays.asList(ppi1));

		PixApplicationData pad1 = new PixApplicationData(null, "VERSION_NUMBER", "NAME_SDK", ppi1);
	
		PixTransactionData ptd1  = new PixTransactionData(null, "iVBORw0KGgoAAAANSUhEUgAABRQAAAUUCAYAAACu5p7oAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAIABJREFUeJzs2luO3LiWQNFmI+Y/Zd6vRt36KGNXi7ZOBtcagHD4kNLeiLX33v8DAAAAABD879sDAAAAAAA/h6AIAAAAAGSCIgAAAACQCYoAAAAAQCYoAgAAAACZoAgAAAAAZIIiAAAAAJAJigAAAABAJigCAAAAAJmgCAAAAABkgiIAAAAAkAmKAAAAAEAmKAIAAAAAmaAIAAAAAGSCIgAAAACQCYoAAAAAQCYoAgAAAACZoAgAAAAAZIIiAAAAAJAJigAAAABAJigCA", "00020126600014br.gov.bcb.pix0117john@yourdomain.com0217additionaldata520400005303986540510.005802BR5913MariaSilva6008Brasilia62070503***6304E2CA", ppi1);
		
		pixApplicationDataRepository.saveAll(Arrays.asList(pad1));
		pixTransactionDataRepository.saveAll(Arrays.asList(ptd1));
		//fim mercado pago
	}
 }
