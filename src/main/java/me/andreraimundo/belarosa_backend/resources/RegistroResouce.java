package me.andreraimundo.belarosa_backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.services.RegistroService;

@RestController
@RequestMapping(value = "/registros")
public class RegistroResouce {

    @Autowired
    RegistroService registroService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <?> find (@PathVariable Integer id){
       Registro obj = registroService.find(id);
     return ResponseEntity.ok().body(obj); 
    }
}
