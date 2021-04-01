package me.andreraimundo.belarosa_backend.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import me.andreraimundo.belarosa_backend.services.DBInitialService;

@Configuration
@Profile("dev")
public class DevConfig {
    
    @Autowired
    private DBInitialService dbInitialService;

    @Bean
    public boolean instantiateDataBase () throws ParseException {
        dbInitialService.instantiateTestDataBase();
        return true;
    }
}

