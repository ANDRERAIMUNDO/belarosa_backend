package me.andreraimundo.belarosa_backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Endereco;
import me.andreraimundo.belarosa_backend.repositories.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired  
    private EnderecoRepository enderecoRepository;
    
    public Endereco find (Integer id){
        Optional <Endereco> obj = enderecoRepository.findById(id);
        return obj.orElse(null);
    }
    
}
