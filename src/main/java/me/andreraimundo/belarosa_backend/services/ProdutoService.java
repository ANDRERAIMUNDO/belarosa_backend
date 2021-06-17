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

    public Produto find (Integer id){
       
        Optional <Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Produto não encontrado Id: "+ id + " Tipo: "
         + Produto.class.getName()));
    }

    public Produto insert (Produto obj) {
        obj.setId(null);
      return produtoRepository.save(obj);
    }

    public Produto update (Produto obj) {
        Produto newObj = find(obj.getId());
        updateData(newObj, obj);
        return produtoRepository.save(newObj);
    }

    public void delete (Integer id){
        find(id);
        try {
            produtoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir produto associado a pedido");
        }
    }

    public Page<Produto> searchAll (String name, Integer page, Integer linesPerPage) {//conserta

        UserSS user = UserService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Você deve esta logado! .");
        }   
       PageRequest pageRequest = PageRequest.of(page, linesPerPage);
       return produtoRepository.findByFirstNameIgnoreCase (name, pageRequest);
	 } 

     public Page<Produto> searchAllProdutosAdultos(String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
       
        UserSS user = UserService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Você deve esta logado! .");   
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return produtoRepository.findDistinctByNameContainingAndCategoriasIn(name, categorias, pageRequest);
    }

    public Page<Produto> search(String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return produtoRepository.findDistinctByNameContainingAndCategoriasIn(name, categorias, pageRequest);
	}

    public Produto fromDTO (ProdutoDTO objDto ) {
        return new Produto(null, objDto.getName(), objDto.getPrice());
    }

    public Produto fromDTO ( NewProdutoDTO objDto) {
        List <Categoria> categorias = new ArrayList<>(objDto.getCategorias());
        Produto prod = new Produto(null,objDto.getName(),objDto.getPrice());
        prod.getCategorias().addAll(categorias);
        return prod;
    }
    //enviar imagem para o buckt aws s3
    public URI uploadpProduto(MultipartFile multipartFile) {

		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Você precisa está logado! ");
		}

		//BufferedImage jpgImage = imagesService.getJpgImageFromFile(multipartFile);
		BufferedImage jpgImage = imagesService.getJpgImageFromFile(multipartFile);
        jpgImage = imagesService.cropSquare(jpgImage);
		jpgImage = imagesService.resize(jpgImage, size);
		
		String fileName = prefix + ".jpg";
		
		return s3Service.uploadFileProdutc(imagesService.getInputStream(jpgImage, "jpg"), fileName, "image");
    }

    private void updateData (Produto newObj, Produto obj) {
        newObj.setName(obj.getName());
        newObj.setPrice(obj.getPrice());
    }
}

