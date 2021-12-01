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
import me.andreraimundo.belarosa_backend.dto.UpdatePassowordDTO;
import me.andreraimundo.belarosa_backend.repositories.RegistroRepository;
import me.andreraimundo.belarosa_backend.security.UserSS;
import me.andreraimundo.belarosa_backend.services.exception.DataIntegrityException;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;
import me.andreraimundo.belarosa_backend.services.emails.EmailService;
import me.andreraimundo.belarosa_backend.services.exception.AuthorizationException;

@Service
public class RegistroService {

    @Autowired  
    private RegistroRepository registroRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    EmailService emailService;

//busca por id 
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
//inserir registro
    @Transactional
    public Registro insert (Registro obj) {
        Registro aux = registroRepository.findByEmail(obj.getEmail());
        if (aux != null) {
            throw new DataIntegrityException("Email já existe! ");
        }
        obj.setId(null);
        obj = registroRepository.save(obj);
     //   emailService.newAccountHtml(obj);
        return obj;
    }
//atualizar registro    
    public Registro update (Registro obj) {
        Registro newObj = find(obj.getId());
        Registro aux = registroRepository.findByEmail(obj.getEmail());
        if (aux != null) {
            throw new DataIntegrityException("Email já existe! ");
        }        
        updateDataEmail(newObj, obj);
        emailService.sendNoticationChangerHtmlRegistro(obj);
        return registroRepository.save(newObj);
}
//atualizar senha
    public Registro updatePassword (Registro obj) {
        Registro newObj = find (obj.getId());
        updateDataPassword(newObj, obj);
       // emailService.sendNoticationChangerHtmlRegistro(obj);
        return registroRepository.save(newObj);
    }
//deleta senha
    public void delete (Integer id) {
        find(id);
        try {
            registroRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException ("Não é possivel excluir um registro associado a um pedido");
        }
    }
//busca todos os registro
    public List <Registro> findAll () {
        return registroRepository.findAll();
    }
//busca email padrao spring
    public Registro findByEmail (String email) {
        Registro obj = registroRepository.findByEmail(email);

        if (obj == null) {
            throw new ObjectNotFoundException("Email não encontrado! "
            + "Tipo: " + Registro.class.getName());
        }
        return obj;
    }
//busca email e enviar email de confirmacao da alteração de dados
public Registro findByEmailSendEmailHtmlUpdateDates (String email) {
    Registro obj = registroRepository.findByEmail(email);

    if (obj == null) {
        throw new ObjectNotFoundException("Email não encontrado! "
        + "Tipo: " + Registro.class.getName());
    }
    emailService.sendNoticationChangerHtmlRegistro(obj);
    return obj;
}   
//busca email e enviar email de confirmacao
    public Registro findByEmailSendEmailHtml (String email) {
        Registro obj = registroRepository.findByEmail(email);

        if (obj == null) {
            throw new ObjectNotFoundException("Email não encontrado! "
            + "Tipo: " + Registro.class.getName());
        }
        emailService.newAccountHtml(obj);
        return obj;
    }   
//busca registro com paginas
    public Page<Registro> search(String email, Integer page, Integer linesPerPages, String orderBy, String direction) {
		PageRequest pageResquest = PageRequest.of(page, linesPerPages,Direction.valueOf(direction), orderBy);
		return registroRepository.search(email, pageResquest);
	}
//busca lista de emails com paginas
    public Page<Registro> findPage(Integer page, Integer linesPerPages, String orderBy, String direction){
		PageRequest pageResquest = PageRequest.of(page, linesPerPages,Direction.valueOf(direction), orderBy);
		return registroRepository.findAll(pageResquest);
	}
//registo dto
    public Registro fromDTOO (RegistroDTO objDto) {
        return new Registro(objDto.getId(), objDto.getEmail(), null);
    }
// registro dto atualização de senha
    public Registro fromDTO (UpdatePassowordDTO objDto) {
        return new Registro(objDto.getId(), null, pe.encode(objDto.getPassword()));
      // return new Registro(null, null, pe.encode(objDto.getPassword()));
    }
// registro dto novo registro
    public Registro fromDTO (NewRegistroDTO objDto) {

        Registro reg = new Registro(
            null,
            objDto.getEmail(),
            pe.encode(objDto.getPassword())
        );
            return reg;
    }
// void atualização email
    private void updateDataEmail (Registro newObj, Registro obj) {
        newObj.setEmail(obj.getEmail());
    }
// void atualização senha
    private void updateDataPassword (Registro newObj, Registro obj) {
        newObj.setPassword(obj.getPassword());
    }
}

