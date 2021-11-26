package me.andreraimundo.belarosa_backend.services.emails;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.domain.Registro;

public interface EmailService {
	void sendEmail(SimpleMailMessage msg);
	void sendHtmlEmail(MimeMessage msg); 

	void sendOrderConfirmationPedido (Pedido obj);
	void sendOrderConfirmationHtmlPedido(Pedido obj);

	//void sendOrderConfirmationMercadoPago (Pedido obj);

	void sendNewPasswordEmail(Registro obj, String newPassword);
	void sendNewPasswordHtmlEmail(Registro obj, String newPassword);

	void sendNoticationChangerRegistro(Registro obj);
	void sendNoticationChangerHtmlRegistro(Registro obj);

	void newAccount(Registro obj);
	void newAccountHtml (Registro obj);
}