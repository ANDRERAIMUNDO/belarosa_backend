package me.andreraimundo.belarosa_backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.andreraimundo.belarosa_backend.domain.Produto;
import me.andreraimundo.belarosa_backend.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <?> find(@PathVariable Integer id){
        Produto objProduto = produtoService.find(id);
        return ResponseEntity.ok().body(objProduto);
    }
}
