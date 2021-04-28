package me.andreraimundo.belarosa_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.Cliente;
import me.andreraimundo.belarosa_backend.domain.Endereco;
import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.dto.ClienteDTO;
import me.andreraimundo.belarosa_backend.dto.NewClienteDTO;
import me.andreraimundo.belarosa_backend.repositories.ClienteRepository;
import me.andreraimundo.belarosa_backend.repositories.EnderecoRepository;
import me.andreraimundo.belarosa_backend.repositories.RegistroRepository;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;


@Service
public class ClienteService {

    @Autowired  
    private ClienteRepository clienteRepository;

    @Autowired 
    EnderecoRepository enderecoRepository;

    @Autowired
    RegistroRepository registroRepository;
    
    public Cliente find (Integer id){
        Optional <Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Cliente inexistente: "+ id + " Tipo: "
         + Cliente.class.getName()));
    }
    
    @Transactional
    public Cliente insert (Cliente obj) {
        obj.setId(null);
        obj = clienteRepository.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    public Cliente update (Cliente obj) {
        Cliente newObj = find(obj.getId());
            updateData(newObj, obj);
            return clienteRepository.save(newObj);
        
    }

    public void delete (Integer id) {
        find(id);
        try {
            registroRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException ("Não é possivel excluir cliente associado a um pedido");
        }
    }

    public List <Cliente> findAll () {
        return clienteRepository.findAll();
    }

    public Cliente findByName (String name) {
        Cliente obj = clienteRepository.findByName(name);

        if (obj == null) {
            throw new ObjectNotFoundException("Nome não encontrado! "
            + "Tipo: " + Cliente.class.getName());
        }
        return obj;
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPages, String orderBy, String direction){
		PageRequest pageResquest = PageRequest.of(page, linesPerPages,Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageResquest);
	}

    public Cliente fromDTO (ClienteDTO objDto) {
        return new Cliente(null, null, objDto.getName(), null, null, objDto.getPhone());
    }

    public Cliente fromDTO (NewClienteDTO objDto) {

        Registro reg = new Registro(
            objDto.getRegistroId(),
            null,
            null,
            null);
        
        Cliente cli = new Cliente(
            reg, 
            null,
            objDto.getName(), 
            objDto.getCpf(), 
            objDto.getDateNasc(),
            objDto.getPhone());
            
        Endereco end = new Endereco(
            null, 
            objDto.getCep(), 
            objDto.getLogradouro(), 
            objDto.getNumero(), 
            objDto.getComplemento(), 
            objDto.getBairro(), 
            objDto.getLocalidade(), 
            objDto.getUf(), 
            reg, 
            cli);

            cli.getEnderecos().add(end);
            return cli;
    }

    private void updateData (Cliente newObj, Cliente obj) {
        newObj.setName(obj.getName());
        newObj.setPhone(obj.getPhone());
    }

}
