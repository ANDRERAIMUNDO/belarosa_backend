package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import me.andreraimundo.belarosa_backend.domain.Pedido;

public class UpdateStatusPaymentPedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private Integer statusPayment;
    
    public UpdateStatusPaymentPedidoDTO() {
    	
    }

    public UpdateStatusPaymentPedidoDTO (Pedido obj) {
    	id  = obj.getId();
    	statusPayment = obj.getStatusPayment();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatusPayment() {
		return statusPayment;
	}


	public void setStatusPayment(Integer statusPayment) {
		this.statusPayment = statusPayment;
	}

}	
