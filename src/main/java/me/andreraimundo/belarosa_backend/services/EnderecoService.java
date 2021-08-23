package me.andreraimundo.belarosa_backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Endereco;
import me.andreraimundo.belarosa_backend.domain.enums.Perfil;
import me.andreraimundo.belarosa_backend.repositories.EnderecoRepository;
import me.andreraimundo.belarosa_backend.security.UserSS;
import me.andreraimundo.belarosa_backend.services.exception.AuthorizationException;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco find (Integer id) {
	
	UserSS user = UserService.authenticated();
        if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
            throw new AuthorizationException("Acesso negado! .");
        }
        Optional <Endereco> obj  = enderecoRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Registro não encontrado Id: "+ id + " Tipo: "
         + Endereco.class.getName()));
    }
    
}
