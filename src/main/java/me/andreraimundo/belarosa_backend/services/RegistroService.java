package me.andreraimundo.belarosa_backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.repositories.RegistroRepository;

@Service
public class RegistroService {

    @Autowired  
    private RegistroRepository registroRepository;
    
    public Registro find (Integer id){
        Optional <Registro> objCategoria = registroRepository.findById(id);
        return objCategoria.orElse(null);
    }
    
}
