package com.backend.api.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.backend.api.models.Cliente;
import com.backend.api.models.Pedido;

public class SmtpMailService extends AbstractEmailService{

	private static final Logger LOG = LoggerFactory.getLogger(SmtpMailService.class);
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Enviando email...");
		mailSender.send(msg);
		LOG.info("email enviado...");
		
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Enviando email HTML...");
		javaMailSender.send(msg);
		LOG.info("email enviado...");
		
	}

	@Override
	public void sendNewPasswordEmail(Cliente cliente, String newPass) {
		// TODO Auto-generated method stub
		
	}

}
