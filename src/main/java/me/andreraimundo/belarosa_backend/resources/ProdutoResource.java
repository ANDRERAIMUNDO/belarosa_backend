package me.andreraimundo.belarosa_backend.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <?> find(@PathVariable Integer id){
        Produto obj = produtoService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity <Void> insert ( @Valid @RequestBody NewProdutoDTO objDto) {
      Produto obj = produtoService.fromDTO(objDto);
      obj = produtoService.insert(obj);
      URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}").buildAndExpand(obj.getId()).toUri();
      return ResponseEntity.created(uri).build();
    }

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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<ProdutoDTO>> findAll() {
      List <Produto> list = produtoService.findAll();
      List<ProdutoDTO>listDto = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
      return ResponseEntity.ok().body(listDto);
    }	

//  @RequestMapping(value = "/page", method = RequestMethod.GET)
//	public ResponseEntity<Page<ProdutoDTO>> findPage(
//			@RequestParam(value="page", defaultValue = "0")Integer page, 
//			@RequestParam(value="linesPerPage", defaultValue = "24")Integer linesPerPage, 
//			@RequestParam(value="orderBy", defaultValue = "name")String orderBy, 
//			@RequestParam(value="direction", defaultValue = "ASC")String direction) {
//		Page <Produto> list = produtoService.findPage(page, linesPerPage, orderBy, direction);
//		Page<ProdutoDTO>listDto = list.map(obj -> new ProdutoDTO(obj));
//		return ResponseEntity.ok().body(listDto);
//	}
@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<Page<ProdutoDTO>> findPage(
				@RequestParam(value="name", defaultValue = "")String name, 
				@RequestParam(value="categorias", defaultValue = "")String categorias, 
				@RequestParam(value="page", defaultValue = "0")Integer page, 
				@RequestParam(value="linesPerPages", defaultValue = "24")Integer linesPerPage, 
				@RequestParam(value="orderBy", defaultValue = "name")String orderBy, 
				@RequestParam(value="direction", defaultValue = "ASC")String direction) {
			String nomeDecoded = URL.decodeParam(name);
			List <Integer> ids = URL.decodeIntList(categorias);
			Page <Produto> list = produtoService.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
			Page<ProdutoDTO>listDto = list.map(obj -> new ProdutoDTO(obj));
			return ResponseEntity.ok().body(listDto);
		}	

  }

