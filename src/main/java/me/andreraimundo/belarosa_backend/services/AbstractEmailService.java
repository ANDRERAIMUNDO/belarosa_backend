package me.andreraimundo.belarosa_backend.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.domain.Registro;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendOrderConfirmationEmail(Pedido obj) {
        SimpleMailMessage sm =  prepareSimpleMailMessageFromPedido(obj);
        sendEmail(sm);     
    }

   protected  SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
    SimpleMailMessage sm = new SimpleMailMessage();
    sm.setTo(obj.getRegistro().getEmail());
    sm.setFrom(sender);
    sm.setSubject("Pedido confirmado, Codigo: "+obj.getId());
    sm.setSentDate(new Date(System.currentTimeMillis()));
    sm.setText(obj.toString());    
    return sm;
   }
    
   @Override
	public void sendNewPasswordEmail(Registro registro, String newPassword) {
		SimpleMailMessage sm = prepareNewPasswordEmail(registro, newPassword);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareNewPasswordEmail(Registro registro, String newPassword) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(registro.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPassword);
		return sm;
	}
}   
