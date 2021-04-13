package me.andreraimundo.belarosa_backend.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.andreraimundo.belarosa_backend.domain.Cliente;
import me.andreraimundo.belarosa_backend.dto.ClienteDTO;
import me.andreraimundo.belarosa_backend.dto.NewClienteDTO;
import me.andreraimundo.belarosa_backend.services.ClienteService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <?> find (@PathVariable Integer id){
        Cliente obj = clienteService.find(id);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity <Void> insert ( @Valid @RequestBody NewClienteDTO objDto) {
      Cliente obj = clienteService.fromDTO(objDto);
      obj = clienteService.insert(obj);
      URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}").buildAndExpand(obj.getId()).toUri();
      return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@Valid @RequestBody ClienteDTO objDto,@PathVariable Integer id) {
      Cliente obj  = clienteService.fromDTO(objDto);
      obj.setId(id);
      obj = clienteService.update(obj);
      return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable Integer id) {
      clienteService.delete(id);
      return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity <List<ClienteDTO>> findALl () {
      List<Cliente> list = clienteService.findAll();
      List<ClienteDTO> listDto = list.stream()
      .map(obj -> new ClienteDTO(obj))
      .collect(Collectors.toList());
      return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findPage(
        @RequestParam(value="page", defaultValue = "0")Integer page, 
        @RequestParam(value="linesPerPages", defaultValue = "24")Integer linesPerPages, 
        @RequestParam(value="orderBy", defaultValue = "nome")String orderBy, 
        @RequestParam(value="direction", defaultValue = "ASC")String direction) {
      Page <Cliente> list = clienteService.findPage(page, linesPerPages, orderBy, direction);
      Page<ClienteDTO>listDto = list.map(obj -> new ClienteDTO(obj));
      return ResponseEntity.ok().body(listDto);
    }
  }