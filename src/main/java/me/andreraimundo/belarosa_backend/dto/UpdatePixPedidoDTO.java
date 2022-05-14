package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import me.andreraimundo.belarosa_backend.domain.Pedido;

public class UpdatePixPedidoDTO  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String pixPayment_id;
    
    public UpdatePixPedidoDTO() {
    	
    }

    public UpdatePixPedidoDTO (Pedido obj) {
    	id  = obj.getId();
    	pixPayment_id = obj.getPixPayment_id();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPixPayment_id() {
		return pixPayment_id;
	}

	public void setPixPayment_id(String pixPayment_id) {
		this.pixPayment_id = pixPayment_id;
	}
}
