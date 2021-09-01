package me.andreraimundo.belarosa_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.Descricao;
import me.andreraimundo.belarosa_backend.dto.DescricaoDTO;
import me.andreraimundo.belarosa_backend.repositories.DescricaoRepository;
import me.andreraimundo.belarosa_backend.services.exception.DataIntegrityException;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class DescricaoService {
    @Autowired
    private DescricaoRepository descricaoRepository;
//find
public Descricao find (Integer id) {
    Optional <Descricao> obj  = descricaoRepository.findById(id);
    return obj.orElseThrow(() -> new 
    ObjectNotFoundException("Descrição não encontrado Id: "+ id + " Tipo: "
    + Descricao.class.getName()));
}
//insert
public Descricao insert (Descricao obj) {
    obj.setId(null);
    return obj = descricaoRepository.save(obj);
}
//update
public Descricao update (Descricao obj) {
    Descricao newObj = find(obj.getId());
    updateData(newObj, obj);
    return descricaoRepository.save(newObj);
}
// delete
public void delete (Integer id){
    find(id);
    try {
        descricaoRepository.deleteById(id);
    } catch (DataIntegrityException e) {
        throw new DataIntegrityException("Não é possivel excluir descricao associada a um produto");
    }
}
//updateDTO
public Descricao fromDTO (DescricaoDTO objDto) {
    return new Descricao(objDto.getId(), objDto.getName());
}
// update de class para classDTO
private void updateData(Descricao newObj, Descricao obj) {
    newObj.setName(obj.getName());
}
// findall categoria
public List <Descricao> findAll () {
    return descricaoRepository.findAll();
}

}
