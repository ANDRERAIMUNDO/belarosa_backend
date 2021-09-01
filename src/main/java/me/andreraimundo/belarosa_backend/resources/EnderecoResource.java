package me.andreraimundo.belarosa_backend.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.andreraimundo.belarosa_backend.domain.Endereco;
import me.andreraimundo.belarosa_backend.dto.EnderecoDTO;
import me.andreraimundo.belarosa_backend.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
    
    @Autowired
    EnderecoService enderecoService;
//get enderecos
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find (@PathVariable Integer id){
        Endereco obj  = enderecoService.find(id);
        return ResponseEntity.ok(obj);
    }
//put endereco
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@Valid @RequestBody EnderecoDTO objDto,@PathVariable Integer id) {
        Endereco obj  = enderecoService.fromDTO(objDto);
        obj.setId(id);
        obj = enderecoService.update(obj);
        return ResponseEntity.noContent().build();
}
}
