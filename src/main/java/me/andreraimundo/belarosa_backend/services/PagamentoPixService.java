package me.andreraimundo.belarosa_backend.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.PagamentoPix;

@Service
public class PagamentoPixService {
    public void pagamentoPix (PagamentoPix pagamentoPix, Date instatePedido) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(instatePedido);
        pagamentoPix.setDataPedido(cal.getTime());
    }
}