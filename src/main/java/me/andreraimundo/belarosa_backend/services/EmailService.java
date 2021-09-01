package me.andreraimundo.belarosa_backend.services;

import org.springframework.mail.SimpleMailMessage;

import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.domain.Registro;

public interface EmailService {
	void sendOrderConfirmationEmail (Pedido obj);
	void sendEmail(SimpleMailMessage msg);
	void sendNewPasswordEmail(Registro registro, String newPassword);
	void sendNoticationChangerPasswordEmail(Registro registro);
	void newAccount(Registro registro);
}