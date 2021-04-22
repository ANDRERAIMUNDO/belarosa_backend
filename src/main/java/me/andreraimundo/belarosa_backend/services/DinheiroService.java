package me.andreraimundo.belarosa_backend.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.PagamentoDinheiro;

@Service
public class DinheiroService {
    public void pagamentoAvista (PagamentoDinheiro pagamentoDinheiro, Date instatePedido) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(instatePedido);
        pagamentoDinheiro.setDataPagamento(cal.getTime());
    }
}
