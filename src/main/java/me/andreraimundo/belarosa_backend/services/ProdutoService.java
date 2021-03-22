package me.andreraimundo.belarosa_backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Produto;
import me.andreraimundo.belarosa_backend.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired  
    private ProdutoRepository produtoRepository;
    
    public Produto find (Integer id){
        Optional <Produto> objCategoria = produtoRepository.findById(id);
        return objCategoria.orElse(null);
    }
    
}
