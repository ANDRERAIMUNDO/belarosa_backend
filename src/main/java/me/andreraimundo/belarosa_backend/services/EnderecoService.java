package me.andreraimundo.belarosa_backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Endereco;
import me.andreraimundo.belarosa_backend.dto.EnderecoDTO;
import me.andreraimundo.belarosa_backend.repositories.EnderecoRepository;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
//find
    public Endereco find (Integer id) {
        Optional <Endereco> obj  = enderecoRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Registro não encontrado Id: "+ id + " Tipo: "
         + Endereco.class.getName()));
    }
//update
    public Endereco update (Endereco obj) {
    Endereco newObj = find(obj.getId());
        updateData(newObj, obj);
        return enderecoRepository.save(newObj);
    
    }
    public Endereco fromDTO (EnderecoDTO objDto) {
        return new Endereco(null, objDto.getCep(), objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getLocalidade(), objDto.getUf(), null, null);
    }
//atualizando endereco atraves de EnderecoDTO
    private void updateData (Endereco newObj, Endereco obj) {
        newObj.setCep(obj.getCep());
        newObj.setLogradouro(obj.getLogradouro());
        newObj.setNumero(obj.getNumero());
        newObj.setComplemento(obj.getComplemento());
        newObj.setBairro(obj.getBairro());
        newObj.setLocalidade(obj.getLocalidade());
        newObj.setUf(obj.getUf());
    }
}
