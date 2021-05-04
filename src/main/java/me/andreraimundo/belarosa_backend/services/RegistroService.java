package me.andreraimundo.belarosa_backend.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.domain.enums.Perfil;
import me.andreraimundo.belarosa_backend.dto.NewRegistroDTO;
import me.andreraimundo.belarosa_backend.dto.RegistroDTO;
import me.andreraimundo.belarosa_backend.repositories.RegistroRepository;
import me.andreraimundo.belarosa_backend.security.UserSS;
import me.andreraimundo.belarosa_backend.services.exception.DataIntegrityException;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;
import me.andreraimundo.belarosa_backend.services.exception.AuthorizationException;

@Service
public class RegistroService {

    @Autowired  
    private RegistroRepository registroRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    public Registro find (Integer id){
        UserSS user = UserService.authenticated();
        if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
            throw new AuthorizationException("Acesso negado! .");
        }
        Optional <Registro> obj = registroRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Registro não encontrado Id: "+ id + " Tipo: "
         + Registro.class.getName()));
    }
    
    @Transactional
    public Registro insert (Registro obj) {

        Registro aux = registroRepository.findByEmail(obj.getEmail());
        if (aux != null) {
            throw new DataIntegrityException("Email já existe! ");
        }
        obj.setId(null);
        obj = registroRepository.save(obj);
        return obj;
    }

    public Registro update (Registro obj) {
        Registro newObj = find(obj.getId());
        Registro aux = registroRepository.findByEmail(obj.getEmail());
        if (aux != null) {
            throw new DataIntegrityException("Email já existe! ");
        }        
        updateData(newObj, obj);
        return registroRepository.save(newObj);
        
    }
   
    public void delete (Integer id) {
        find(id);
        try {
            registroRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException ("Não é possivel excluir um registro associado a um pedido");
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

    public Page<Registro> findPage(Integer page, Integer linesPerPages, String orderBy, String direction){
		PageRequest pageResquest = PageRequest.of(page, linesPerPages,Direction.valueOf(direction), orderBy);
		return registroRepository.findAll(pageResquest);
	}

    public Registro fromDTO (RegistroDTO objDto) {
        return new Registro(objDto.getId(), objDto.getEmail(), null);
    }

    public Registro fromDTO (NewRegistroDTO objDto) {

        Registro reg = new Registro(
            null,
            objDto.getEmail(),
            pe.encode(objDto.getPassword())
        );
            return reg;
    }

    private void updateData (Registro newObj, Registro obj) {
        newObj.setEmail(obj.getEmail());
    }
}

