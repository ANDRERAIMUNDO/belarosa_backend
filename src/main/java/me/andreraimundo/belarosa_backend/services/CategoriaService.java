package me.andreraimundo.belarosa_backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Categoria;
import me.andreraimundo.belarosa_backend.repositories.CategoriaRepository;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

    @Autowired  
    private CategoriaRepository categoriaRepository;
    
    public Categoria find (Integer id){
        Optional <Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado ! Id; " + id +"Tipo: "+ Categoria.class.getName()));
    }
    
}
