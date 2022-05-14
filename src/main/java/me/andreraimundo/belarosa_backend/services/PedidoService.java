package me.andreraimundo.belarosa_backend.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.ItemPedido;
import me.andreraimundo.belarosa_backend.domain.PagamentoBoleto;
import me.andreraimundo.belarosa_backend.domain.PagamentoDinheiro;
import me.andreraimundo.belarosa_backend.domain.PagamentoPix;
import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.domain.ReservaDePedido;
import me.andreraimundo.belarosa_backend.domain.enums.Perfil;
import me.andreraimundo.belarosa_backend.domain.enums.SituacaoPedido;
import me.andreraimundo.belarosa_backend.dto.ReservaPedidoDTO;
import me.andreraimundo.belarosa_backend.dto.UpdatePixPedidoDTO;
import me.andreraimundo.belarosa_backend.dto.UpdateStatusPaymentPedidoDTO;
import me.andreraimundo.belarosa_backend.repositories.ItemPedidoRepository;
import me.andreraimundo.belarosa_backend.repositories.PagamentoRepository;
import me.andreraimundo.belarosa_backend.repositories.PedidoRepository;
import me.andreraimundo.belarosa_backend.repositories.RegistroRepository;
import me.andreraimundo.belarosa_backend.security.UserSS;
import me.andreraimundo.belarosa_backend.services.emails.EmailService;
import me.andreraimundo.belarosa_backend.services.exception.AuthorizationException;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
    
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    RegistroRepository registroRepository;
    
    @Autowired
    BoletoService boletoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    RegistroService registroService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    DinheiroService dinheiroService;

    @Autowired
    ReservaDePedidoService reservaDePedidoService;

    @Autowired
    PagamentoPixService pagamentoPixService;

    @Autowired
    EmailService emailService;
//find pedido
    public Pedido find (Integer id) {
    	Optional <Pedido> obj = pedidoRepository.findById(id);
        UserSS user = UserService.authenticated();
    	Registro registro = registroRepository.findByEmail(user.getUsername());
    	var registroId = registro.getId();
    	var pedidoId = obj.get().getRegistro().getId();
    		if (!user.hasRole(Perfil.ADMIN) && !registroId.equals(pedidoId))
    			{
                	throw new AuthorizationException("Pedido não pertence ao Usuario requisitado!, ou não possui privilégios necessarios.");
    			}
       //
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Pedido não encontrado Id: "+ id + " Tipo: "
         + Pedido.class.getName()));
    }
//insert pedido
    @Transactional
    public Pedido insert (Pedido obj) {
        obj.setId(null);
        obj.setInstante(new Date());
        obj.setRegistro(registroService.find(obj.getRegistro().getId()));
        obj.setCliente(clienteService.find(obj.getCliente().getId()));
        obj.getPagamento().setSituacaoPedido(SituacaoPedido.QUITADO);
        obj.getPagamento().setPedido(obj);

        if (obj.getPagamento() instanceof PagamentoBoleto) {
            PagamentoBoleto pagamentoBoleto = (PagamentoBoleto) obj.getPagamento();
            boletoService.preencherPegamentoComBoleto(pagamentoBoleto, obj.getInstante());
        }
        if (obj.getPagamento() instanceof PagamentoDinheiro) {
            PagamentoDinheiro pagamentoDinheiro = (PagamentoDinheiro) obj.getPagamento();
            dinheiroService.pagamentoAvista(pagamentoDinheiro, obj.getInstante());
            obj.getPagamento().setSituacaoPedido(SituacaoPedido.QUITADO);
        }
        if (obj.getPagamento() instanceof ReservaDePedido) {
            ReservaDePedido reservaDePedido = (ReservaDePedido) obj.getPagamento();
            reservaDePedidoService.reservaDePedido(reservaDePedido, obj.getInstante());
            obj.getPagamento().setSituacaoPedido(SituacaoPedido.PENDENTE);
        }
        if (obj.getPagamento() instanceof PagamentoPix) {
            PagamentoPix pagamentoPix = (PagamentoPix) obj.getPagamento();
            pagamentoPixService.pagamentoPix(pagamentoPix, obj.getInstante());
            obj.getPagamento().setSituacaoPedido(SituacaoPedido.PENDENTE);
        }
        obj = pedidoRepository.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido itemPedido : obj.getItens()) {
            itemPedido.setDesconto(0.0);
            itemPedido.setProduto(produtoService.find(itemPedido.getProduto().getId()));
            itemPedido.setPrice(itemPedido.getProduto().getPrice());
            itemPedido.setPedido(obj);
        }   
        itemPedidoRepository.saveAll(obj.getItens());
         //emailService.sendOrderConfirmationHtmlPedido(obj);//alterando em 18 de agosto de 2021
        
        return obj;
    }
    
    public Pedido updateStatusPaymenty(Pedido obj) {
    	Optional <Pedido> objPedido = pedidoRepository.findById(obj.getId());
        UserSS user = UserService.authenticated();
    	Registro registro = registroRepository.findByEmail(user.getUsername());
    	var registroId = registro.getId();
    	var pedidoId = objPedido.get().getRegistro().getId();
    	
    		if (!user.hasRole(Perfil.ADMIN) && !registroId.equals(pedidoId))
    			{
                	throw new AuthorizationException("Pedido não pertence ao Usuario requisitado!, ou não possui privilégios necessarios.");
    			}
          Pedido newObj = find(obj.getId());
          updateStatusPaymenty(newObj, obj);
             
          return pedidoRepository.save(newObj);
    }
    
    private void updateStatusPaymenty (Pedido newObj, Pedido obj) {
        newObj.setStatusPayment(obj.getStatusPayment());
    }
    
    public Pedido updateStatusPaymentyfromDTO (UpdateStatusPaymentPedidoDTO objDto) {
  
    	return new Pedido(null, null, null, null, null, objDto.getStatusPayment(), null, null);
    }
    
    
    public Pedido updatePixPaymenty(Pedido obj) {
    	Optional <Pedido> objPedido = pedidoRepository.findById(obj.getId());
        UserSS user = UserService.authenticated();
    	Registro registro = registroRepository.findByEmail(user.getUsername());
    	var registroId = registro.getId();
    	var pedidoId = objPedido.get().getRegistro().getId();
    	
    		if (!user.hasRole(Perfil.ADMIN) && !registroId.equals(pedidoId))
    			{
                	throw new AuthorizationException("Pedido não pertence ao Usuario requisitado!, ou não possui privilégios necessarios.");
    			}
          Pedido newObj = find(obj.getId());
          updatePixPaymenty(newObj, obj);
             
          return pedidoRepository.save(newObj);
    }
    
    private void updatePixPaymenty (Pedido newObj, Pedido obj) {
        newObj.setPixPayment_id(obj.getPixPayment_id());
    }
    
    public Pedido updatePixPaymentyfromDTO (UpdatePixPedidoDTO objDto) {
  
    	return new Pedido(null, null, null, null, null, null, objDto.getPixPayment_id(), null);
    }
    
    
    public Pedido updatePedidoReseva(Pedido obj) {
    	Optional <Pedido> objPedido = pedidoRepository.findById(obj.getId());
        UserSS user = UserService.authenticated();
    	Registro registro = registroRepository.findByEmail(user.getUsername());
    	var registroId = registro.getId();
    	var pedidoId = objPedido.get().getRegistro().getId();
    	
    		if (!user.hasRole(Perfil.ADMIN) && !registroId.equals(pedidoId))
    			{
                	throw new AuthorizationException("Pedido não pertence ao Usuario requisitado!, ou não possui privilégios necessarios.");
    			}
          Pedido newObj = find(obj.getId());
          updatePedidoReserv(newObj, obj);
             
          return pedidoRepository.save(newObj);
    }
    
    private void updatePedidoReserv (Pedido newObj, Pedido obj) {
        newObj.setReservaPedido(obj.getReservaPedido());
    }
    
    public Pedido updatePedidoResevafromDTO (ReservaPedidoDTO objDto) {
  
    	return new Pedido(null, null, null, null, null, null, null, objDto.getReservaPedido());
    }
    
//find page pedido
    public Page<Pedido> findPage(Integer page, Integer linesPerPages, String orderBy, String direction) {
        UserSS user = UserService.authenticated();
        if( user == null){
            throw new AuthorizationException("Acesso negado");
        }
        PageRequest pageRequest = PageRequest.of(page, linesPerPages, Direction.valueOf(direction), orderBy);
		Registro registro =  registroService.find(user.getId());
		return pedidoRepository.findByRegistro(registro, pageRequest);    
	}
 //pesquisar pedidos de cliente id
    public Page<Pedido> findByPedidoId (String id, Integer page, Integer linesPerPages) {
    PageRequest pageRequest = PageRequest.of(page, linesPerPages);
    return pedidoRepository.findByPedidoId(id, pageRequest);
} 
}

///implementar put pedido