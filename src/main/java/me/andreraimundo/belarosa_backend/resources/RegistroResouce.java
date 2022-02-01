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

import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.dto.NewRegistroDTO;
import me.andreraimundo.belarosa_backend.dto.RegistroDTO;
import me.andreraimundo.belarosa_backend.dto.UpdatePassowordDTO;
import me.andreraimundo.belarosa_backend.services.RegistroService;
import me.andreraimundo.belarosa_backend.resources.utils.URL;

@RestController
@RequestMapping(value = "/registros")
public class RegistroResouce {

    @Autowired
    RegistroService registroService;

//busca registro por id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <Registro> find (@PathVariable Integer id){
       Registro obj = registroService.find(id);
     return ResponseEntity.ok().body(obj); 
    }
// busca registro por email
    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public ResponseEntity <Registro> find (@RequestParam(value = "value") String email) {
      Registro obj = registroService.findByEmail(email);  
      return ResponseEntity.ok().body(obj);
    }

//enviar email nova conta
    @RequestMapping(value = "/send_email_new_account", method = RequestMethod.GET)
    public ResponseEntity <Registro> emailNewAccount (@RequestParam(value = "value") String email) {
      Registro obj = registroService.emailNewAccount(email);  
      return ResponseEntity.ok().body(obj);
    }
//enviar email atulizacao de registro
@RequestMapping(value = "/send_email_update", method = RequestMethod.GET)
public ResponseEntity <Registro> emailUpdateAccount (@RequestParam(value = "value") String email) {
  Registro obj = registroService.emailUpdateAccount(email);  
  return ResponseEntity.ok().body(obj);
}
// inserir registro
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity <Void> insert ( @Valid @RequestBody NewRegistroDTO objDto) {
      Registro obj = registroService.fromDTO(objDto);
      obj = registroService.insert(obj);
      URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}").buildAndExpand(obj.getId()).toUri();
      return ResponseEntity.created(uri).build();
    }
//atualizando email
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity <Void> update (@Valid @RequestBody RegistroDTO objDto, @PathVariable Integer id) {
      Registro obj = registroService.fromDTOO(objDto);
      obj.setId(id);
      obj = registroService.update(obj);
      return ResponseEntity.noContent().build();
    }
//atualiza senha sem retorno
    @RequestMapping(value = "newpass/{id}", method = RequestMethod.PUT)
    public ResponseEntity <Void> updatePassword (@Valid @RequestBody UpdatePassowordDTO objDto, @PathVariable Integer id) {
      Registro obj = registroService.fromDTO(objDto);
      obj.setId(id);
      obj = registroService.updatePassword(obj);
      return ResponseEntity.noContent().build();
    }
// retorna de todos os registros
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<RegistroDTO>> findAll () {
      List <Registro> list = registroService.findAll();
      List <RegistroDTO> listDto = list.stream().map(
        obj -> new RegistroDTO(obj))
        .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
// deletar registro
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity <Void> delete (@PathVariable Integer id) {
      registroService.delete(id);
      return ResponseEntity.noContent().build();
    }
//busca registro por paginação
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity <Page<RegistroDTO>> findPage (
      @RequestParam(value="page", defaultValue = "0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "10")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "name")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC")String direction){
        Page <Registro> list = registroService.findPage(page, linesPerPage, orderBy, direction);
        Page<RegistroDTO> listDto = list.map(obj -> new RegistroDTO(obj));
        return ResponseEntity.ok().body(listDto); 
      }
//busca email por paginação
      @PreAuthorize("hasRole('ADMIN')")
      @RequestMapping(value="/page/email", method = RequestMethod.GET)
      public ResponseEntity<Page<RegistroDTO>> findPage(
          @RequestParam(value="email", defaultValue = "")String email, 
          @RequestParam(value="page", defaultValue = "0")Integer page, 
          @RequestParam(value="linesPerPages", defaultValue = "24")Integer linesPerPages, 
          @RequestParam(value="orderBy", defaultValue = "email")String orderBy, 
          @RequestParam(value="direction", defaultValue = "ASC")String direction) {
        String nomeDecoded = URL.decodeParam(email);
        Page <Registro> list = registroService.search(nomeDecoded, page, linesPerPages, orderBy, direction);
        Page<RegistroDTO>listDto = list.map(obj -> new RegistroDTO(obj));
        return ResponseEntity.ok().body(listDto);
      }	
}
