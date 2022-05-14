package me.andreraimundo.belarosa_backend.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Locale;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern="dd/MM/yyyy hh:mm")
    private Date instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;
    
    @ManyToOne 
    @JoinColumn(name = "registro_id")
    private Registro registro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;

    @OneToMany(mappedBy = "id.pedido")
    private Set <ItemPedido> itens = new HashSet<>();
    
    private String statusPayment;
    
    private String pixPayment_id;
    
    private String reservaPedido;
    
    public Pedido() {

    }

    public Pedido(Integer id, Date instante, Registro registro, Cliente cliente, Endereco enderecoDeEntrega,String statusPayment, String pixPayment_id, String reservaPedido) {
        super();
        this.id = id;
        this.instante = instante;
        this.registro= registro;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
        this.statusPayment = statusPayment;
        this.pixPayment_id = pixPayment_id;
        this.reservaPedido = reservaPedido;
    }

    public double getValorTotal() {
		double soma = 0.0;
		for (ItemPedido ip : itens) {
			soma = soma  + ip.getSubTotal();
		}
		return soma;
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

	public String getStatusPayment() {
		return statusPayment;
	}

	public void setStatusPayment(String statusPayment) {
		this.statusPayment = statusPayment;
	}

	public String getPixPayment_id() {
		return pixPayment_id;
	}

	public void setPixPayment_id(String pixPayment_id) {
		this.pixPayment_id = pixPayment_id;
	}

	public String getReservaPedido() {
		return reservaPedido;
	}

	public void setReservaPedido(String reservaPedido) {
		this.reservaPedido = reservaPedido;
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
        Pedido other = (Pedido) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append("Pedido número: ");
		stringbuilder.append(getId());
		stringbuilder.append(", Instante: ");
		stringbuilder.append(sdf.format(getInstante()));
		stringbuilder.append(", Cliente: ");
		stringbuilder.append(getCliente().getName());
    //    stringbuilder.append(", Email: ");
    //    stringbuilder.append(getRegistro().getEmail());
		stringbuilder.append(" Situação do pagamento: ");
		stringbuilder.append(getPagamento().getSituacaoPedido().getdescricao());
		stringbuilder.append("\nDetalhes: \n");
		for (ItemPedido ip : getItens()) {
			stringbuilder.append(ip.toString());
		}
		stringbuilder.append("Valor total: ");
		stringbuilder.append(numberFormat.format(getValorTotal()));
		return stringbuilder.toString();
	}
}
