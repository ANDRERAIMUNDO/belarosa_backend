package me.andreraimundo.belarosa_backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Categoria;
import me.andreraimundo.belarosa_backend.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired  
    private CategoriaRepository categoriaRepository;
    
    public Categoria find (Integer id){
        Optional <Categoria> objCategoria = categoriaRepository.findById(id);
        return objCategoria.orElse(null);
    }
    
}
