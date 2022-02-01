package me.andreraimundo.belarosa_backend.resources.mp;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import me.andreraimundo.belarosa_backend.dto.mercadopago.PixPayment;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PixPaymentDTO;
import me.andreraimundo.belarosa_backend.services.PixMpPaymentService;

@RestController
@RequestMapping("/pix_process_payment")
public class PixPaymentResource {

@Autowired
PixMpPaymentService pixMpPaymentService;
    
//post
@RequestMapping(method = RequestMethod.POST)
public ResponseEntity<Void> insert(@Valid @RequestBody PixPaymentDTO objDto) {
    PixPayment obj = pixMpPaymentService.fromDTO(objDto); 
    URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
    .path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).build();
}
//id
@RequestMapping(value = "/{id}", method = RequestMethod.GET)
public ResponseEntity <PixPayment> find (@PathVariable Integer id){
    PixPayment obj = pixMpPaymentService.find(id);
return ResponseEntity.ok().body(obj); 
}
}
