package me.andreraimundo.belarosa_backend;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import me.andreraimundo.belarosa_backend.domain.Categoria;
import me.andreraimundo.belarosa_backend.domain.Cliente;
import me.andreraimundo.belarosa_backend.domain.Produto;
import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.repositories.CategoriaRepository;
import me.andreraimundo.belarosa_backend.repositories.ClienteRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(BelarosaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Bolsas");
		Categoria cat2 = new Categoria(null, "Maquiagem");
	
		Cliente cl1 = new Cliente(null, "Lara Ramos", "630.792.070-09", "13/12/1991", "(91)9 88220467");
		Cliente cl2 = new Cliente(null, "Luana Lobato", "867.738.940-77", "24/06/1998", "(91)9 84001327");
		
		Produto prod1 = new Produto(null, "CARTEIRA VICTORINE", 279.99);
		Produto prod2 = new Produto(null, "	Bolsa Santa Lolla Baú Marrom", 279.99);
		Produto prod3 = new Produto(null, "LES 4 OMBRES QUARTETO DE SOMBRAS MULTIEFEITOS", 199.90);

		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2));
		cat2.getProdutos().addAll(Arrays.asList(prod3));	

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1));
		prod3.getCategorias().addAll(Arrays.asList(cat2));
	
		Registro reg1 = new Registro(null,"9000andre@gmail.com", "admin");
		Registro reg2 = new Registro(null,"andre@gmail.com", "1234");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		clienteRepository.saveAll(Arrays.asList(cl1,cl2));
		registroRepository.saveAll(Arrays.asList(reg1, reg2));
	}

}
