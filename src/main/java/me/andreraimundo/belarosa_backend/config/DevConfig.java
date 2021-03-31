package me.andreraimundo.belarosa_backend.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import me.andreraimundo.belarosa_backend.services.DBInitialService;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBInitialService dbInitialService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantianteDatebase() throws ParseException {
        if (!"create".equals(strategy)) {
            dbInitialService.instantiateTestDataBase();
            return true;
        }
        return false;
    }
}
