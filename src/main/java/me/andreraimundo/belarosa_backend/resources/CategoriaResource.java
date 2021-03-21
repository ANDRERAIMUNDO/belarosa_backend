package me.andreraimundo.belarosa_backend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.andreraimundo.belarosa_backend.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @RequestMapping(method = RequestMethod.GET)
    public List <Categoria> list (){
        Categoria cat1 = new Categoria(1,"Bolsas");
        Categoria cat2 = new Categoria(2,"Maquiagem");

        List<Categoria> list = new ArrayList<>();
        list.add(cat1);
        list.add(cat2);
        return list;
    }
}
