package me.andreraimundo.belarosa_backend.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

import me.andreraimundo.belarosa_backend.domain.enums.SituacaoPedido;

@Entity
@JsonTypeName("pagamentoDinheiro")
public class PagamentoDinheiro  extends Pagamento {

    private static final long serialVersionUID = 1L;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataPagamento;

    public PagamentoDinheiro () {

    }

    public PagamentoDinheiro(Integer id, SituacaoPedido situacaoPedido, Pedido pedido, Date dataPagamento) {
        super(id, situacaoPedido, pedido);
        this.dataPagamento =dataPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    
}
