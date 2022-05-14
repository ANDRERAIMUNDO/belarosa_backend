package me.andreraimundo.belarosa_backend.services;

import java.util.Arrays;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PayerUser;
import me.andreraimundo.belarosa_backend.dto.mercadopago.ProcessPayment;
import me.andreraimundo.belarosa_backend.dto.mercadopago.ProcessPaymentDTO;
import me.andreraimundo.belarosa_backend.dto.mercadopago.StatusPayment;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.PayerUserRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.ProcessPaymentRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.StatusPaymentRepository;
import me.andreraimundo.belarosa_backend.services.exception.MercadoPagoException;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class PaymentProcessService {

    @Autowired
    private ProcessPaymentRepository processPaymentRepository;

    @Autowired
    private PayerUserRepository payerRepository;

    @Autowired
    private StatusPaymentRepository statusPaymentRepository;
    
    @Value("${mercado_pago_sample_access_token}")
    private String mercadoPagoAccessToken;

    private static final Logger LOG = LoggerFactory.getLogger(PaymentProcessService.class);
//busca por id 
    public ProcessPayment find (Integer id){
        Optional <ProcessPayment> obj = processPaymentRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Processp de pagamento não encontrado Id: "+ id + " Tipo: "
         + ProcessPayment.class.getName()));
    }
    
//findById    
    public StatusPayment findById (Integer id){
        Optional <StatusPayment> obj = statusPaymentRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Processp de pagamento não encontrado Id: "+ id + " Tipo: "
         + StatusPayment.class.getName()));
    }
//inserir ProcessPayment
    @Transactional
    public ProcessPayment insert (ProcessPayment obj) {
        return obj;
    }
// ProcessPayment dto novo ProcessPayment
    public ProcessPayment fromDTO (ProcessPaymentDTO objDto) {

        try  {
            MercadoPago.SDK.setAccessToken(mercadoPagoAccessToken);

            Payment payment = new Payment();
    
            double d = objDto.getTransaction_amount();
            float f = (float)d;
            payment.setTransactionAmount(f)
                    .setToken(objDto.getToken())
                    .setDescription(objDto.getDescription())
                    .setInstallments(objDto.getInstallments())
                    .setPaymentMethodId(objDto.getPayment_method_id());
            
            Payer payer = new Payer();
            payer.setEmail(objDto.getEmail());
            payment.setPayer(payer);

            Payment obj = payment.save();
            
            LOG.info("Enviando dados");
            LOG.info("status = " + obj.getStatus());
            LOG.info("status_detail = " + obj.getStatusDetail());
            LOG.info("id = " + obj.getId());
            LOG.info("date_approved = " + obj.getDateApproved());
            LOG.info("payment_method_id = " + obj.getPaymentMethodId());
            LOG.info("payment_type_id = " + obj.getPaymentTypeId());
            LOG.info("Fim do processo");
            //localmysql
            Registro reg = new Registro(
                objDto.getRegistroId(),
                null,
                null);
            ProcessPayment pp = new ProcessPayment(
                null, 
                objDto.getTransaction_amount(), 
                objDto.getToken(), 
                objDto.getDescription(), 
                objDto.getInstallments(),
                objDto.getPayment_method_id(),
                objDto.getIssuer_id());
         
            PayerUser payerUser = new PayerUser(
                null, 
                objDto.getEmail(), 
                pp);
            
            processPaymentRepository.save(pp);
            pp.getPayers().addAll(Arrays.asList(payerUser));

            payerRepository.saveAll(Arrays.asList(payerUser));

            StatusPayment sp  = new StatusPayment(
                reg,
                pp,
                null, 
                obj.getId(), 
                obj.getStatus().toString(), 
                obj.getStatusDetail(),   
                obj.getPaymentMethodId(),
                obj.getPaymentTypeId().toString(),
                obj.getDateApproved());  

            statusPaymentRepository.save(sp);
            return pp;
            //localmysql
        }
            catch (MPException exception) {
                throw new MercadoPagoException(exception.getMessage());
            }
    }
//pesquisar todos os produtos ultizando IgnoreCase
    public Page<StatusPayment> searchAll (String name, Integer page, Integer linesPerPage) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage);
        return statusPaymentRepository.findByFirstNameIgnoreCase (name, pageRequest);
    }
    
    }
