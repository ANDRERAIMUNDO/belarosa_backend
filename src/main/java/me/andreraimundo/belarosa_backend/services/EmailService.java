package me.andreraimundo.belarosa_backend.services;

import org.springframework.mail.SimpleMailMessage;

import me.andreraimundo.belarosa_backend.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationEmail (Pedido obj);
	void sendEmail(SimpleMailMessage msg);
}