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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.andreraimundo.belarosa_backend.domain.Cliente;
import me.andreraimundo.belarosa_backend.dto.ClienteDTO;
import me.andreraimundo.belarosa_backend.dto.NewClienteDTO;
import me.andreraimundo.belarosa_backend.dto.PageClienteDTO;
import me.andreraimundo.belarosa_backend.resources.utils.URL;
import me.andreraimundo.belarosa_backend.services.ClienteService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    ClienteService clienteService;
//get clientes
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <Cliente> find (@PathVariable Integer id){
        Cliente obj = clienteService.find(id);
        return ResponseEntity.ok().body(obj);
    }
//post clientes
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity <Void> insert ( @Valid @RequestBody NewClienteDTO objDto) {
      Cliente obj = clienteService.fromDTO(objDto);
      obj = clienteService.insert(obj);
      URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}").buildAndExpand(obj.getId()).toUri();
      return ResponseEntity.created(uri).build();
    }
//put clientes
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update (@Valid @RequestBody ClienteDTO objDto,@PathVariable Integer id) {
      Cliente obj  = clienteService.fromDTO(objDto);
      obj.setId(id);
      obj = clienteService.update(obj);
      return ResponseEntity.noContent().build();
    }
//delete clientes somente admin
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable Integer id) {
      clienteService.delete(id);
      return ResponseEntity.noContent().build();
    }
//get clientes por nomes somente admin
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public ResponseEntity <Cliente> find (@RequestParam(value = "value") String name) {
      Cliente obj = clienteService.findByName(name);  
      return ResponseEntity.ok().body(obj);
    }
//get findall clientes somente admin
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity <List<ClienteDTO>> findALl () {
      List<Cliente> list = clienteService.findAll();
      List<ClienteDTO> listDto = list.stream()
      .map(obj -> new ClienteDTO(obj))
      .collect(Collectors.toList());
      return ResponseEntity.ok().body(listDto);
    }
//findPage
     //@PreAuthorize("hasRole('ADMIN')")
     @RequestMapping(value = "/page", method = RequestMethod.GET)
     public ResponseEntity<Page<PageClienteDTO>> findPage(
            @RequestParam(value="name", defaultValue = "")String name,
            @RequestParam(value="page", defaultValue = "0")Integer page, 
            @RequestParam(value="linesPerPages", defaultValue = "24")Integer linesPerPages) {
          String nomeDecoded = URL.decodeParam(name);
          Page <Cliente> list = clienteService.findPage(nomeDecoded, page, linesPerPages);
          Page<PageClienteDTO>listDto = list.map(obj -> new PageClienteDTO(obj));
          return ResponseEntity.ok().body(listDto);
      }

//post imagem 
  	@RequestMapping(value="/imageprofile", method=RequestMethod.POST)
	  public ResponseEntity<Void>uploadProfilePicture(@RequestParam(name="file") MultipartFile file){
		URI uri = clienteService.uploadCliente(file);
		return ResponseEntity.created(uri).build();
	}
}