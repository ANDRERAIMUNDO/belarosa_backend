package me.andreraimundo.belarosa_backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <?> find (Integer id){
       Registro objRegistro = registroService.find(id);
     return ResponseEntity.ok().body(objRegistro); 
    }
}
