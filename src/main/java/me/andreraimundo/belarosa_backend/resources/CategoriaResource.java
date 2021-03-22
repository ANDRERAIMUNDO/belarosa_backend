package me.andreraimundo.belarosa_backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.andreraimundo.belarosa_backend.domain.Categoria;
import me.andreraimundo.belarosa_backend.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @Autowired
    CategoriaService categoriaService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find (@PathVariable Integer id) {
        Categoria objcategoria = categoriaService.find(id);
        return ResponseEntity.ok().body(objcategoria);
    }
}
