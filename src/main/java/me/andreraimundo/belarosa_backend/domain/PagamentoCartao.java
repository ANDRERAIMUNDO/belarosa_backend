package me.andreraimundo.belarosa_backend.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import me.andreraimundo.belarosa_backend.domain.enums.SituacaoPedido;

@Entity
@JsonTypeName("pagamentoCartao")
public class PagamentoCartao extends Pagamento {

    private static final long serialVersionUID = 1L;
    
    private Integer numerosDeParcelas;

    public PagamentoCartao () {
        
    }

    public PagamentoCartao(Integer id, SituacaoPedido situacaoPedido, Pedido pedido, Integer numeroDeParcelas) {
        super(id, situacaoPedido, pedido);
        this.numerosDeParcelas = numeroDeParcelas;
    }

    public Integer getNumerosDeParcelas() {
        return numerosDeParcelas;
    }

    public void setNumerosDeParcelas(Integer numerosDeParcelas) {
        this.numerosDeParcelas = numerosDeParcelas;
    }
    
}
