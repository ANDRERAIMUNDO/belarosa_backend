package me.andreraimundo.belarosa_backend.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();
    private Double desconto;
    private Integer quantidade;
    private Double price;

    public ItemPedido() {

    }

    public ItemPedido (Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double price) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.price = price;
    }

    public double getSubTotal() {
		return (price - desconto) * quantidade;
	}

    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }
    public Produto getProduto() {
        return id.getProduto();
    }
    public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
    public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemPedido other = (ItemPedido) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
		NumberFormat numberFormaf = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
		StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(", Produto: ");
		stringbuilder.append(getProduto().getName());
		stringbuilder.append(", Qte: ");
		stringbuilder.append(getQuantidade());
		stringbuilder.append(", Preço unitário: ");
		stringbuilder.append(numberFormaf.format(getPrice()));
		stringbuilder.append(", SubTotal: ");
		stringbuilder.append(numberFormaf.format(getSubTotal()));
		stringbuilder.append("\n");
		return stringbuilder.toString();
	}
    
}
