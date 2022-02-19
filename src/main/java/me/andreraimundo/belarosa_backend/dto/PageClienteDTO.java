package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import me.andreraimundo.belarosa_backend.domain.Cliente;
import me.andreraimundo.belarosa_backend.domain.Endereco;
import me.andreraimundo.belarosa_backend.domain.Pedido;
import me.andreraimundo.belarosa_backend.domain.Registro;

public class PageClienteDTO  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;
    private String cpf;
    private String dateNasc;
    private String phone;

    @JsonIgnore
    private Registro  registro;

    private List <Endereco> enderecos = new ArrayList<>();
    private List <Pedido> pedidos = new ArrayList<>();


    public PageClienteDTO () {

    }

    public PageClienteDTO ( Cliente obj) {
        id = obj.getId();
        name = obj.getName();
        cpf = obj.getCpf();
        dateNasc = obj.getDateNasc();
        phone = obj.getPhone();
        registro = obj.getRegistro();
        enderecos = obj.getEnderecos();
        pedidos = obj.getPedidos();
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDateNasc() {
		return dateNasc;
	}

	public void setDateNasc(String dateNasc) {
		this.dateNasc = dateNasc;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

    
}
