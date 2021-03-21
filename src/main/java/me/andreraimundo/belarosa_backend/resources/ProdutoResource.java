package me.andreraimundo.belarosa_backend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.andreraimundo.belarosa_backend.domain.Produto;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @RequestMapping(method = RequestMethod.GET)
    public List <Produto> list (){
        Produto pro1 = new Produto (1, "Bolsa Zatana", 29.99);
        Produto pro2 = new Produto (2, "Maquiagem Delux", 13.99);

        List<Produto> list = new ArrayList<>();
        list.add(pro1);
        list.add(pro2);
        return list;
    }
}
