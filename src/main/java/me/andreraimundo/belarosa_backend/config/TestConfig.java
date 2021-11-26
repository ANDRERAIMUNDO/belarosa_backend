package me.andreraimundo.belarosa_backend.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import me.andreraimundo.belarosa_backend.services.DBInitialService;
import me.andreraimundo.belarosa_backend.services.emails.EmailService;
import me.andreraimundo.belarosa_backend.services.emails.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
    
    @Autowired
    private DBInitialService dbInitialService;

    @Bean
    public boolean instantianteDataBase () throws ParseException {
        dbInitialService.instantiateTestDataBase();
        return true;
    }
    @Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
