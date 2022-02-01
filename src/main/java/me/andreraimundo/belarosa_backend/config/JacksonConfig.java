package me.andreraimundo.belarosa_backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import me.andreraimundo.belarosa_backend.domain.PagamentoBoleto;
import me.andreraimundo.belarosa_backend.domain.PagamentoCartao;
import me.andreraimundo.belarosa_backend.domain.PagamentoDinheiro;
import me.andreraimundo.belarosa_backend.domain.PagamentoPix;
import me.andreraimundo.belarosa_backend.domain.ReservaDePedido;

@Configuration
public class JacksonConfig {
    
    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder () {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder(){
            public void configure (ObjectMapper objectMapper) {
                objectMapper.registerSubtypes(PagamentoBoleto.class);
                objectMapper.registerSubtypes(PagamentoCartao.class);
                objectMapper.registerSubtypes(PagamentoDinheiro.class);
                objectMapper.registerSubtypes(ReservaDePedido.class);
                objectMapper.registerSubtypes(PagamentoPix.class);
            super.configure(objectMapper);
            }
        };
        return builder;
    }
}
