package me.andreraimundo.belarosa_backend.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import me.andreraimundo.belarosa_backend.domain.ReservaDePedido;

@Service
public class ReservaDePedidoService {
    public void reservaDePedido (ReservaDePedido reservaDePedido, Date instatePedido) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(instatePedido);
        reservaDePedido.setDataPedido(cal.getTime());
    }
}