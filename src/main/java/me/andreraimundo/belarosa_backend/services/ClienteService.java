package me.andreraimundo.belarosa_backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Cliente;
import me.andreraimundo.belarosa_backend.repositories.ClienteRepository;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

    @Autowired  
    private ClienteRepository clienteRepository;
    
    public Cliente find (Integer id){
        Optional <Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Objeto não encontrado Id: "+ id + " Tipo: "
         + Cliente.class.getName()));
    }
    
}
