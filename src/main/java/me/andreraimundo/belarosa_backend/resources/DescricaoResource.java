package me.andreraimundo.belarosa_backend.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import me.andreraimundo.belarosa_backend.services.DescricaoService;
import me.andreraimundo.belarosa_backend.domain.Descricao;
import me.andreraimundo.belarosa_backend.dto.DescricaoDTO;

@RestController
@RequestMapping(value = "/descricoes")
public class DescricaoResource {
  
    @Autowired
    DescricaoService descricaoService;
//get descricao
@RequestMapping(value = "/{id}", method = RequestMethod.GET)
public ResponseEntity <Descricao> find (@PathVariable Integer id){
    Descricao obj = descricaoService.find(id);
    return ResponseEntity.ok().body(obj);
}
//post descricao
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(method = RequestMethod.POST)
public ResponseEntity <Void> insert ( @Valid @RequestBody DescricaoDTO objDto) {
  Descricao obj = descricaoService.fromDTO(objDto);
  obj = descricaoService.insert(obj);
  URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
  .path("/{id}").buildAndExpand(obj.getId()).toUri();
  return ResponseEntity.created(uri).build();
}
//put descricao
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
public ResponseEntity<Void> update (@Valid @RequestBody DescricaoDTO objDto,@PathVariable Integer id) {
  Descricao obj  = descricaoService.fromDTO(objDto);
  obj.setId(id);
  obj = descricaoService.update(obj);
  return ResponseEntity.noContent().build();
}
//delete categorias
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/{id}", method =  RequestMethod.DELETE)
public ResponseEntity <Void> delete (@PathVariable Integer id) {
  descricaoService.delete(id);
    return ResponseEntity.noContent().build();
}
}
