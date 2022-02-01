package me.andreraimundo.belarosa_backend.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

import me.andreraimundo.belarosa_backend.domain.enums.SituacaoPedido;

@Entity
@JsonTypeName("pagamentoPix")
public class PagamentoPix extends Pagamento {

    private static final long serialVersionUID = 1L;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataPedido;

    private String status;

    public PagamentoPix() {

    }

    public PagamentoPix(Integer id, SituacaoPedido situacaoPedido, Pedido pedido, Date dataPedido, String status) {
		super(id, situacaoPedido, pedido);
        this.dataPedido = dataPedido;
        this.status = status;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}