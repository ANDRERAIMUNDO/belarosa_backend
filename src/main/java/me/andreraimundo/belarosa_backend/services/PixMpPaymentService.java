package me.andreraimundo.belarosa_backend.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Address;
import com.mercadopago.resources.datastructures.payment.Identification;
import com.mercadopago.resources.datastructures.payment.Payer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.andreraimundo.belarosa_backend.dto.mercadopago.PixPayment;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PixPaymentDTO;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PixTransactionDetails;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PixPointOfInteraction;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PixTransactionData;
import me.andreraimundo.belarosa_backend.domain.Registro;
import me.andreraimundo.belarosa_backend.dto.mercadopago.PixApplicationData;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.PixApplicationDataRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.PixPaymentRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.PixPointOfInteractionRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.PixTransactionDataRepository;
import me.andreraimundo.belarosa_backend.repositories.mercadopago.PixTransactionDetailsRepository;
import me.andreraimundo.belarosa_backend.security.UserSS;
import me.andreraimundo.belarosa_backend.services.emails.EmailService;
import me.andreraimundo.belarosa_backend.services.exception.AuthorizationException;
import me.andreraimundo.belarosa_backend.services.exception.MercadoPagoException;
import me.andreraimundo.belarosa_backend.services.exception.ObjectNotFoundException;

@Service
public class PixMpPaymentService {


@Value("${mercado_pago_sample_access_token}")
private String mercadoPagoAccessToken;

@Autowired
private PixApplicationDataRepository pixApplicationDataRepository;
@Autowired
private PixPaymentRepository pixPaymentRepository;
@Autowired
private PixPointOfInteractionRepository pixPointOfInteractionRepository;
@Autowired
private PixTransactionDataRepository pixTransactionDataRepository;
@Autowired
private PixTransactionDetailsRepository pixTransactionDatailsRepository;
@Autowired
private EmailService emailService;

private static final Logger LOG = LoggerFactory.getLogger(PixMpPaymentService.class);
    
//inserir
    @Transactional
    public PixPayment insert (PixPayment obj) {
        //obj.setId(null);
        //obj = pixPaymentRepository.save(obj);
        return obj;
    }
//inset DTO   
    public PixPayment fromDTO (PixPaymentDTO objDto) {

        try  {
            MercadoPago.SDK.setAccessToken(mercadoPagoAccessToken);

            Payment payment = new Payment();
            
            double d = objDto.getTransactionAmount();
            float f = (float)d;
            payment.setTransactionAmount(f)
                .setDescription(objDto.getDescription())
                .setPaymentMethodId(objDto.getPaymentMethodId())
                .setPayer(new Payer()
                    .setEmail(objDto.getEmail())
                    .setFirstName(objDto.getFirstName())
                    .setLastName(objDto.getLastName())
                    
                    .setIdentification(new Identification()
                        .setType(objDto.getType())
                        .setNumber(objDto.getNumber()))
                    .setAddress(new Address()
                        .setZipCode(objDto.getZipCode())
                        .setStreetName(objDto.getStreetName())
                        .setStreetNumber(objDto.getStreetNumber())
                        .setCity(objDto.getCity())
                        .setFederalUnit(objDto.getFederalUnit()))
            );

            Payment obj = payment.save();

            LOG.info("Enviando dados");
            LOG.info("id" + obj.getId());
            LOG.info("status" + obj.getStatus());
            LOG.info("staus details" + obj.getStatusDetail());
            LOG.info("receivedAmount" + obj.getTransactionDetails().getNetReceivedAmount());
            LOG.info("totalPaidAmount" + obj.getTransactionDetails().getTotalPaidAmount());
            LOG.info("overpaidAmount" + obj.getTransactionDetails().getTotalPaidAmount());
            LOG.info("installmentAmount" + obj.getTransactionDetails().getInstallmentAmount());
            LOG.info("ExternalResourceUrl" + obj.getTransactionDetails().getExternalResourceUrl());
            LOG.info( "getFinancialInstitution" +  obj.getTransactionDetails().getFinancialInstitution());
            LOG.info ("type" + obj.getPointOfInteraction().getType());
            LOG.info ("subtype" + obj.getPointOfInteraction().getSubType());
            LOG.info ("name" + obj.getPointOfInteraction().getApplicationData().getName()); 
            LOG.info ("version" + obj.getPointOfInteraction().getApplicationData().getVersion()); 
            LOG.info ("codebase64" + obj.getPointOfInteraction().getTransactionData().getQrCodeBase64());
            LOG.info ("qrcode" + obj.getPointOfInteraction().getTransactionData().getQrCode());

            Registro reg = new Registro(
                objDto.getRegistroId(),
                null,
                null);
                
            PixPayment px = new PixPayment(
                reg,
                null, 
                obj.getId(),
                obj.getStatus().toString(),
                obj.getStatusDetail());
            
            pixPaymentRepository.save(px);

            float f1 =  obj.getTransactionDetails().getNetReceivedAmount();// analisar conversao de valor
            float f2 = obj.getTransactionDetails().getTotalPaidAmount();// analisar conversao de valor
            float f3 = obj.getTransactionDetails().getTotalPaidAmount();// analisar conversao de valor
            float f4 = obj.getTransactionDetails().getInstallmentAmount(); // analisar conversao de valor

            double receivedAmount = (float)f1;
            double totalPaidAmount = (float)f2;
            double overpaidAmount  = (float)f3;
            double installmentAmount = (float)f4;

            PixTransactionDetails pxtd = new PixTransactionDetails(
                null, 
                receivedAmount, 
                totalPaidAmount,
                overpaidAmount,
                obj.getTransactionDetails().getExternalResourceUrl(), 
                installmentAmount,
                obj.getTransactionDetails().getFinancialInstitution(), 
                px);
            
            PixPointOfInteraction pxpoi = new PixPointOfInteraction(
                null, 
                obj.getPointOfInteraction().getType(),
                obj.getPointOfInteraction().getSubType(),
                px);

            PixApplicationData pxad = new PixApplicationData(
                null, 
                obj.getPointOfInteraction().getApplicationData().getName(), 
                obj.getPointOfInteraction().getApplicationData().getVersion(), 
                pxpoi);
            PixTransactionData pxtdt = new PixTransactionData(
                null, 
                obj.getPointOfInteraction().getTransactionData().getQrCodeBase64(), 
                obj.getPointOfInteraction().getTransactionData().getQrCode(), 
                pxpoi);
               
                pixTransactionDatailsRepository.save(pxtd);
                pixPointOfInteractionRepository.save(pxpoi);
                pixApplicationDataRepository.save(pxad);
                pixTransactionDataRepository.save(pxtdt);

                LOG.info("Enviando email");
               // emailService.sendPixCodeHtml(px);
                LOG.info("Email enviado");

                return px;
        }
            catch (MPException exception) {
                throw new MercadoPagoException(exception.getMessage());
            }
    }
    //busca por id 
    public PixPayment find (Integer id){
        UserSS user = UserService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Precisa esta logado! .");
        }

        Optional <PixPayment> obj = pixPaymentRepository.findById(id);
        return obj.orElseThrow(()-> new 
        ObjectNotFoundException("Processo de pagamento não encontrado Id: "+ id + " Tipo: "
         + PixPayment.class.getName()));
    }

//enviar email
    public PixPayment sendEmail (Integer id) {
        UserSS user = UserService.authenticated();
        if (user == null) {
            throw new AuthorizationException("Acesso negado! .");
        }
        
        Optional <PixPayment> obj = pixPaymentRepository.findById(id);

        if (obj == null) {
            throw new ObjectNotFoundException("Pix processo de pagamento nao encontrado ! "
            + "Tipo: " + PixPayment.class.getName());
        }
       // emailService.sendPixCodeHtml(obj);
        return null;
    }
}