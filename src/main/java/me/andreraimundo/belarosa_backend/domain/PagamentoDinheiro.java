package me.andreraimundo.belarosa_backend.domain;

import javax.persistence.Entity;

import me.andreraimundo.belarosa_backend.domain.enums.SituacaoPedido;

@Entity
public class PagamentoDinheiro  extends Pagamento {

    private static final long serialVersionUID = 1L;
    
    private Double valorRecebido;

    public PagamentoDinheiro () {

    }

    public PagamentoDinheiro(Integer id, SituacaoPedido situacaoPedido, Pedido pedido, Double valorRecebido) {
        super(id, situacaoPedido, pedido);
        this.valorRecebido = valorRecebido;
    }

    public Double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(Double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }  
}
