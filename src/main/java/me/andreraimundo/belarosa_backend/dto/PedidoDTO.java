package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import me.andreraimundo.belarosa_backend.domain.Cliente;
import me.andreraimundo.belarosa_backend.domain.Endereco;
import me.andreraimundo.belarosa_backend.domain.ItemPedido;
import me.andreraimundo.belarosa_backend.domain.Pagamento;
import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.domain.Registro;

public class PedidoDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;

    @JsonFormat(pattern="dd/MM/yyyy hh:mm")
    private Date instante;
    
    private Pagamento pagamento;
    private Registro registro;
    private Cliente cliente;
    private Endereco enderecoDeEntrega;
    private Set <ItemPedido> itens = new HashSet<>();

    public PedidoDTO(Pedido obj) {
    id = obj.getId();
    instante =  obj.getInstante();    
    pagamento = obj.getPagamento();
    registro = obj.getRegistro();
    cliente = obj.getCliente();
    enderecoDeEntrega = obj.getEnderecoDeEntrega();
    itens = obj.getItens();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }
}   