package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import me.andreraimundo.belarosa_backend.domain.Pedido;

public class ReservaPedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String reservaPedido;
    
    public ReservaPedidoDTO () {
    	
    }
    
    public ReservaPedidoDTO (Pedido obj) {
    	id = obj.getId();
    	reservaPedido = obj.getReservaPedido();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReservaPedido() {
		return reservaPedido;
	}

	public void setReservaPedido(String reservaPedido) {
		this.reservaPedido = reservaPedido;
	}    
}
