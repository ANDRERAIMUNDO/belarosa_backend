package me.andreraimundo.belarosa_backend.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.PagamentoBoleto;

@Service
public class BoletoService {
    public void preencherPegamentoComBoleto(PagamentoBoleto pagamentoBoleto, Date instantePedido) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(instantePedido);
        cal.add(Calendar.DAY_OF_MONTH,7);
        pagamentoBoleto.setDataVencimento(cal.getTime());
    }   
}
