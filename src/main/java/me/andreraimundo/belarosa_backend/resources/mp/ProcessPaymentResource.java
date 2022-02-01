package me.andreraimundo.belarosa_backend.resources.mp;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.andreraimundo.belarosa_backend.dto.mercadopago.ProcessPaymentDTO;
import me.andreraimundo.belarosa_backend.dto.mercadopago.StatusPayment;
import me.andreraimundo.belarosa_backend.dto.mercadopago.StatusPaymentDTO;
import me.andreraimundo.belarosa_backend.resources.utils.URL;
import me.andreraimundo.belarosa_backend.dto.mercadopago.ProcessPayment;
import me.andreraimundo.belarosa_backend.services.PaymentProcessService;

@RestController
@RequestMapping("/process_payment")
public class ProcessPaymentResource {

    @Autowired
    PaymentProcessService paymentProcessService;


//id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <ProcessPayment> find (@PathVariable Integer id){
        ProcessPayment obj = paymentProcessService.find(id);
    return ResponseEntity.ok().body(obj); 
    }
//findById
    @RequestMapping(value = "statuspayment/{id}", method = RequestMethod.GET)
    public ResponseEntity <StatusPayment> findById (@PathVariable Integer id){
        StatusPayment obj = paymentProcessService.findById(id);
    return ResponseEntity.ok().body(obj); 
    }
//post
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ProcessPaymentDTO objDto) {
        ProcessPayment obj = paymentProcessService.fromDTO(objDto);
        //obj = paymentProcessService.insert(obj); 
        URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
// findAll
    @RequestMapping(value = "statuspayment/all", method = RequestMethod.GET)
    public ResponseEntity<Page<StatusPaymentDTO>> findPage(
        @RequestParam(value="name", defaultValue = "")String name,
        @RequestParam(value="page", defaultValue = "0")Integer page, 
        @RequestParam(value="linesPerPages", defaultValue = "24")Integer linesPerPage) {
            String nomeDecoded = URL.decodeParam(name);
            Page <StatusPayment> list = paymentProcessService.searchAll(nomeDecoded, page, linesPerPage);
            Page<StatusPaymentDTO>listDto = list.map(obj -> new StatusPaymentDTO(obj));
            return ResponseEntity.ok().body(listDto);
    }
}
