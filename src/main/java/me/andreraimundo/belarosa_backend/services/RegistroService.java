package me.andreraimundo.belarosa_backend.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.domain.enums.TipoUsuario;
import me.andreraimundo.belarosa_backend.dto.NewRegistroDTO;
import me.andreraimundo.belarosa_backend.dto.RegistroDTO;
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

    @Transactional
    public Registro insert (Registro obj) {
        obj.setId(null);
        obj = registroRepository.save(obj);
        return obj;
    }

    public Registro update (Registro obj) {
        Registro newObj = find(obj.getId());
        updateData(newObj, obj);
        return registroRepository.save(newObj);
        
    }

    public void delete (Integer id) {
        find(id);
        try {
            registroRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException ("Não é possivel excluir cliente associado a um pedido");
        }
    }

    public List <Registro> findAll () {
        return registroRepository.findAll();
    }

    public Registro findByEmail (String email) {
        Registro obj = registroRepository.findByEmail(email);

        if (obj == null) {
            throw new ObjectNotFoundException("Email não encontrado! "
            + "Tipo: " + Registro.class.getName());
        }
        return obj;
    }

    public Registro fromDTO (RegistroDTO objDto) {
        return new Registro(objDto.getId(), objDto.getEmail(), null, null);
    }

    public Registro fromDTO (NewRegistroDTO objDto) {

        Registro reg = new Registro(
            null,
            objDto.getEmail(),
            objDto.getPassword(),
            TipoUsuario.toEnum(objDto.getTipoUsuario())
        );
            return reg;
    }

    private void updateData (Registro newObj, Registro obj) {
        newObj.setEmail(obj.getEmail());
    }

}

