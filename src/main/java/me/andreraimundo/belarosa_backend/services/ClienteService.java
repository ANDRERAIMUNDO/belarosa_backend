package me.andreraimundo.belarosa_backend.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import java.awt.image.BufferedImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import me.andreraimundo.belarosa_backend.domain.Cliente;
import me.andreraimundo.belarosa_backend.domain.Endereco;
import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.domain.enums.Perfil;
import me.andreraimundo.belarosa_backend.dto.ClienteDTO;
import me.andreraimundo.belarosa_backend.dto.NewClienteDTO;
import me.andreraimundo.belarosa_backend.repositories.ClienteRepository;
import me.andreraimundo.belarosa_backend.repositories.EnderecoRepository;
import me.andreraimundo.belarosa_backend.repositories.RegistroRepository;
import me.andreraimundo.belarosa_backend.security.UserSS;
import me.andreraimundo.belarosa_backend.services.emails.EmailService;
import me.andreraimundo.belarosa_backend.services.exception.AuthorizationException;
import me.andreraimundo.belarosa_backend.services.exception.DataIntegrityException;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;
import me.andreraimundo.belarosa_backend.services.utils.CPFBR;

@Service
public class ClienteService {
	
    @Autowired  
    private ClienteRepository clienteRepository;

    @Autowired 
    EnderecoRepository enderecoRepository;

    @Autowired
    RegistroRepository registroRepository;

    @Autowired
	private S3Service s3Service;

    @Autowired
    private ImagesService imagesService;

    @Autowired
    private EmailService emailService;
    
	@Value("${img.prefix.client.profile}")
	private String prefix;
	
	@Value("${img.profile.size}")
	private Integer size;
// find
    public Cliente find (Integer id){
        UserSS user = UserService.authenticated();
        if (!user.hasRole(Perfil.ADMIN) && !id.equals(user.getId()))
        {
            throw new AuthorizationException("Somente administrador! .");
        }
        Optional <Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Cliente não encontrado Id: "+ id + " Tipo: "
         + Cliente.class.getName()));
    }
// insert
    @Transactional
    public Cliente insert (Cliente obj) {
        Cliente aux = clienteRepository.findBycpf(obj.getCpf());
        if (aux !=null) {
            throw new DataIntegrityException("Já existe uma conta vinculada a este CPF ! ");
        }
        if (!CPFBR.isValidCPF(obj.getCpf())) {
            throw new DataIntegrityException("CPF invalido! ");
        }
        obj.setId(null);
        obj = clienteRepository.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }
// update
    public Cliente update (Cliente obj) {
        UserSS user = UserService.authenticated();
        if (!user.hasRole(Perfil.ADMIN) && !obj.getId().equals(user.getId()))
        {
            throw new AuthorizationException("Somente administrador! .");
        }
        Cliente newObj = find(obj.getId());
            updateData(newObj, obj);
            return clienteRepository.save(newObj);
    }
//delete
    public void delete (Integer id) {
        find(id);
        try {
            registroRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException ("Não é possivel excluir cliente associado a um pedido");
        }
    }
//findAllCliente    
    public List <Cliente> findAll () {
        return clienteRepository.findAll();
    }
//findBuName
    public Cliente findByName (String name) {
        Cliente obj = clienteRepository.findByName(name);

        if (obj == null) {
            throw new ObjectNotFoundException("Nome não encontrado! "
            + "Tipo: " + Cliente.class.getName());
        }
        return obj;
    }
//findByCPF
    public Cliente findByCPF (String cpf) { 
        Cliente obj = clienteRepository.findBycpf(cpf);
        if (obj ==null) {
            throw new ObjectNotFoundException("CPF não encontrado! "
            + "Tipo: " + Cliente.class.getName());
        }
        return obj;
    }
//findPage
    public Page<Cliente> findPage (String name, Integer page, Integer linesPerPages) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPages);
        return clienteRepository.findByFirstNameIgnoreCase (name, pageRequest);
    } 

    public Cliente fromDTO (ClienteDTO objDto) {
        return new Cliente(null, null, null, null, null, objDto.getPhone());
    }
// insert cliente newClienteDTO
    public Cliente fromDTO (NewClienteDTO objDto) {

        Registro reg = new Registro(
            objDto.getRegistroId(),
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
//atualizando cliente atraves de ClienteDTO
    private void updateData (Cliente newObj, Cliente obj) {
        newObj.setPhone(obj.getPhone());
    }
//enviar imagem para o buckt aws s3
        public URI uploadCliente(MultipartFile multipartFile) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Você precisa está logado! ");
		}
//carrega imagem do cliente
		BufferedImage pngImage = imagesService.getJpgImageFromFile(multipartFile);
		pngImage = imagesService.cropSquare(pngImage);
		pngImage = imagesService.resize(pngImage, size);
		
		String fileName = prefix + user.getId() + ".png";
		
		return s3Service.uploadFile(imagesService.getInputStream(pngImage, "png"), fileName, "image");
    }
}

























