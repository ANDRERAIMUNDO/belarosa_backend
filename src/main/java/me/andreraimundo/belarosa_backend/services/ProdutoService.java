package me.andreraimundo.belarosa_backend.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.awt.image.BufferedImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import me.andreraimundo.belarosa_backend.domain.Categoria;
import me.andreraimundo.belarosa_backend.domain.Descricao;
import me.andreraimundo.belarosa_backend.domain.Produto;
import me.andreraimundo.belarosa_backend.dto.NewProdutoDTO;
import me.andreraimundo.belarosa_backend.dto.ProdutoDTO;
import me.andreraimundo.belarosa_backend.repositories.CategoriaRepository;
import me.andreraimundo.belarosa_backend.repositories.ProdutoRepository;
import me.andreraimundo.belarosa_backend.security.UserSS;
import me.andreraimundo.belarosa_backend.services.exception.AuthorizationException;
import me.andreraimundo.belarosa_backend.services.exception.DataIntegrityException;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

    @Autowired  
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    CategoriaService categoriaService;
    
    @Autowired
	private S3Service s3Service;

    @Autowired
    private ImagesService imagesService;
	
	@Value("${img.prefix.produto.prod}")
	private String prefix;
	
	@Value("${img.prod.size}")
	private Integer size;
//get produto
    public Produto find (Integer id){
       
        Optional <Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Produto não encontrado Id: "+ id + " Tipo: "
         + Produto.class.getName()));
    }
//isert produtos
    public Produto insert (Produto obj) {
        obj.setId(null);
      return produtoRepository.save(obj);
    }
//updade produto
    public Produto update (Produto obj) {
        Produto newObj = find(obj.getId());
        updateData(newObj, obj);
        return produtoRepository.save(newObj);
    }
//delete produtos
    public void delete (Integer id){
        find(id);
        try {
            produtoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir produto associado a pedido");
        }
    }
//pesquisar todos os produtos ultizando IgnoreCase
    public Page<Produto> searchAll (String name, Integer page, Integer linesPerPage) {
       PageRequest pageRequest = PageRequest.of(page, linesPerPage);
       return produtoRepository.findByFirstNameIgnoreCase (name, pageRequest);
	 } 
//pesquisar produtos dentro de uma ou mais categorias
    public Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String name, List<Integer> ids, Integer page, Integer linesPerPages, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPages,Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(name, categorias, pageRequest);
	}
//estanciar produtodto
    public Produto fromDTO (ProdutoDTO objDto ) {
        return new Produto(null, objDto.getName(), objDto.getPrice());
    }
//estanciar newprodutodto
    public Produto fromDTO ( NewProdutoDTO objDto) {
        List <Descricao> descricoes = new ArrayList<>(objDto.getDescricoes());
        List <Categoria> categorias = new ArrayList<>(objDto.getCategorias());

        Produto prod = new Produto(null,objDto.getName(),objDto.getPrice());
        prod.getDescricoes().addAll(descricoes);
        prod.getCategorias().addAll(categorias);
        return prod;
    }
//enviar imagem para o buckt aws s3
    public URI uploadpProduto(MultipartFile multipartFile) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Você precisa está logado! ");
		}
		BufferedImage pngImage = imagesService.getJpgImageFromFile(multipartFile);
        pngImage = imagesService.cropSquare(pngImage);
		pngImage = imagesService.resize(pngImage, size);
		
		String fileName = prefix + ".png";
		
		return s3Service.uploadFileProdutc(imagesService.getInputStream(pngImage, "png"), fileName, "image");
    }
//transfeirir objetos entre classe e classedto
    private void updateData (Produto newObj, Produto obj) {
        newObj.setName(obj.getName());
        newObj.setPrice(obj.getPrice());
    }
}

