package me.andreraimundo.belarosa_backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.repositories.RegistroRepository;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class RegistroService {

    @Autowired  
    private RegistroRepository registroRepository;
    
    public Registro find (Integer id){
        Optional <Registro> obj = registroRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Objeto não encontrado Id: "+ id + " Tipo: "
         + Registro.class.getName()));
    }
    
}
