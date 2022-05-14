package me.andreraimundo.belarosa_backend.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.dto.PedidoDTO;
import me.andreraimundo.belarosa_backend.dto.ReservaPedidoDTO;
import me.andreraimundo.belarosa_backend.dto.UpdatePixPedidoDTO;
import me.andreraimundo.belarosa_backend.dto.UpdateStatusPaymentPedidoDTO;
import me.andreraimundo.belarosa_backend.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
    
    @Autowired
    PedidoService pedidoService;
//get pedido
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <Pedido> find (@PathVariable Integer id) {
        Pedido obj = pedidoService.find(id);
        return ResponseEntity.ok().body(obj);
    }
// post pedido
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity <Void> insert (@RequestBody Pedido obj) {
        obj = pedidoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
//get pedido por paginas
    @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Pedido>> findPage(
            @RequestParam(value="name", defaultValue = "0")String name,
			@RequestParam(value="page", defaultValue = "0")Integer page, 
			@RequestParam(value="linesPerPages", defaultValue = "24")Integer linesPerPages, 
			@RequestParam(value="orderBy", defaultValue = "instante")String orderBy, 
			@RequestParam(value="direction", defaultValue = "DESC")String direction) {
		Page <Pedido> list = pedidoService.findPage(page, linesPerPages, orderBy, direction);
		return ResponseEntity.ok().body(list);
    }
//busca todo os produtos
  @PreAuthorize("hasRole('ADMIN')")
  @RequestMapping(value = "/id", method = RequestMethod.GET)
  public ResponseEntity<Page<PedidoDTO>> findPage(
         @RequestParam(value="id", defaultValue = "")String id,
         @RequestParam(value="page", defaultValue = "0")Integer page, 
         @RequestParam(value="linesPerPages", defaultValue = "24")Integer linesPerPages) {
       //String nomeDecoded = URL.decodeParam(id);
       Page <Pedido> list = pedidoService.findByPedidoId(id, page, linesPerPages);
       Page<PedidoDTO>listDto = list.map(obj -> new PedidoDTO(obj));
       return ResponseEntity.ok().body(listDto);
   }
  
  @RequestMapping(value = "stp/{id}", method = RequestMethod.PUT)
  public ResponseEntity <Void> updateStatusPaymenty (@Valid @RequestBody UpdateStatusPaymentPedidoDTO objDto, @PathVariable Integer id) {
    Pedido obj = pedidoService.updateStatusPaymentyfromDTO(objDto);
    obj.setId(id);
    obj = pedidoService.updateStatusPaymenty(obj);
    return ResponseEntity.noContent().build();
  }
  
  @RequestMapping(value = "stppix/{id}", method = RequestMethod.PUT)
  public ResponseEntity <Void> updatePixPaymenty (@Valid @RequestBody UpdatePixPedidoDTO objDto, @PathVariable Integer id) {
    Pedido obj = pedidoService.updatePixPaymentyfromDTO(objDto);
    obj.setId(id);
    obj = pedidoService.updatePixPaymenty(obj);
    return ResponseEntity.noContent().build();
  }
  
  @RequestMapping(value = "stpreserv/{id}", method = RequestMethod.PUT)
  public ResponseEntity <Void> updateReservaPedido (@Valid @RequestBody ReservaPedidoDTO objDto, @PathVariable Integer id) {
    Pedido obj = pedidoService.updatePedidoResevafromDTO(objDto);
    obj.setId(id);
    obj = pedidoService.updatePedidoReseva(obj);
    return ResponseEntity.noContent().build();
  }
  }
	
