package com.backend.api.services;

import org.springframework.mail.SimpleMailMessage;

import com.backend.api.models.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage msg);
}
