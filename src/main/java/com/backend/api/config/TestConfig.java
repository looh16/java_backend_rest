package com.backend.api.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.backend.api.services.DbService;
import com.backend.api.services.EmailService;
import com.backend.api.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DbService dbService;
	
	@Bean
	public Boolean instatieteDataBase() throws ParseException {
		dbService.instatieteTestDataBase();
		return true;
	}
	
	@Bean
	public EmailService emailService(){

		return new MockEmailService();
	}
}
