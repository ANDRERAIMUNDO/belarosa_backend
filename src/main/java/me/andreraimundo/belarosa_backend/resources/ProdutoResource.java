package me.andreraimundo.belarosa_backend.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.andreraimundo.belarosa_backend.domain.Produto;
import me.andreraimundo.belarosa_backend.dto.NewProdutoDTO;
import me.andreraimundo.belarosa_backend.dto.ProdutoDTO;
import me.andreraimundo.belarosa_backend.resources.utils.URL;
import me.andreraimundo.belarosa_backend.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    ProdutoService produtoService;
//get produto por id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <?> find(@PathVariable Integer id){
        Produto obj = produtoService.find(id);
        return ResponseEntity.ok().body(obj);
    }
//post produto
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity <Void> insert ( @Valid @RequestBody NewProdutoDTO objDto) {
      Produto obj = produtoService.fromDTO(objDto);
      obj = produtoService.insert(obj);
      URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}").buildAndExpand(obj.getId()).toUri();
      return ResponseEntity.created(uri).build();
    }
//put produto somente admin
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@Valid @RequestBody ProdutoDTO objDto,@PathVariable Integer id) {
      Produto obj  = produtoService.fromDTO(objDto);
      obj.setId(id);
      obj = produtoService.update(obj);
      return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable Integer id) {
      produtoService.delete(id);
      return ResponseEntity.noContent().build();
    }

   //busca todo os produtos
  @RequestMapping(value = "/all", method = RequestMethod.GET)
   public ResponseEntity<Page<ProdutoDTO>> findPage(
          @RequestParam(value="name", defaultValue = "")String name,
          @RequestParam(value="page", defaultValue = "0")Integer page, 
          @RequestParam(value="linesPerPages", defaultValue = "24")Integer linesPerPage) {
        String nomeDecoded = URL.decodeParam(name);
        Page <Produto> list = produtoService.searchAll(nomeDecoded, page, linesPerPage);
        Page<ProdutoDTO>listDto = list.map(obj -> new ProdutoDTO(obj));
        return ResponseEntity.ok().body(listDto);
  	}
//get produtos por categorias   
    @RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<Page<ProdutoDTO>> findPage(
				@RequestParam(value="name", defaultValue = "")String name, 
				@RequestParam(value="categorias", defaultValue = "")String categorias, 
				@RequestParam(value="page", defaultValue = "0")Integer page, 
				@RequestParam(value="linesPerPages", defaultValue = "24")Integer linesPerPages, 
				@RequestParam(value="orderBy", defaultValue = "name")String orderBy, 
				@RequestParam(value="direction", defaultValue = "ASC")String direction) {
			String nomeDecoded = URL.decodeParam(name);
      List <Integer> ids = URL.decodeIntList(categorias);
			Page <Produto> list = produtoService.findDistinctByNomeContainingAndCategoriasIn(nomeDecoded, ids, page, linesPerPages, orderBy, direction);
			Page<ProdutoDTO>listDto = list.map(obj -> new ProdutoDTO(obj));
			return ResponseEntity.ok().body(listDto);
		}	
//post imagem s3 
    @PreAuthorize("hasRole('ADMIN')")
  	@RequestMapping(value="/imageproduto", method=RequestMethod.POST)
	  public ResponseEntity<Void>uploadProfilePicture(@RequestParam(name="file") MultipartFile file){ 
		URI uri = produtoService.uploadpProduto(file);
		return ResponseEntity.created(uri).build();
	}

  }
