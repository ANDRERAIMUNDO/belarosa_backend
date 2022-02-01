package me.andreraimundo.belarosa_backend.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

import me.andreraimundo.belarosa_backend.domain.enums.SituacaoPedido;

@Entity
@JsonTypeName("reservaDePedido")
public class ReservaDePedido extends Pagamento {

    private static final long serialVersionUID = 1L;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataPedido;

    private String informacaoDeEntrega;

    public ReservaDePedido() {

    }

    public ReservaDePedido(Integer id, SituacaoPedido situacaoPedido, Pedido pedido, Date dataPedido, String informacaoDeEntrega) {
		super(id, situacaoPedido, pedido);
        this.dataPedido = dataPedido;
        this.informacaoDeEntrega = informacaoDeEntrega;
    }

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getInformacaoDeEntrega() {
		return informacaoDeEntrega;
	}

	public void setInformacaoDeEntrega(String informacaoDeEntrega) {
		this.informacaoDeEntrega = informacaoDeEntrega;
	}
}
