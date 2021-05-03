package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class NewClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer registroId;

    private Integer id;

    @NotEmpty(message = "Campo obrigatorio. ")
    @Size(min = 10, message = "Minimo 10 caracteres. ")
    @Size(max = 40, message = "Maximo 40 caracteres. ")
    private String name;

    @NotEmpty(message = "Campo obrigatorio. ") 
    private String cpf;

    @NotEmpty(message = "Campo obrigatorio. ")
    private String dateNasc;

    @NotEmpty(message = "Campo obrigatorio. ")
    private String phone;

    @NotEmpty(message = "Campo obrigatorio. ")
    private String cep;

    @NotEmpty(message = "Campo obrigatorio. ")
    private String logradouro;

    @NotEmpty(message = "Campo obrigatorio. ")
    private String numero;

    @NotEmpty(message = "Campo obrigatorio. ")
    private String complemento;

    @NotEmpty(message = "Campo obrigatorio. ")
    private String bairro;

    @NotEmpty(message = "Campo obrigatorio. ")
    private String localidade;
    
    @NotEmpty(message = "Campo obrigatorio. ")
    private String uf;

    public NewClienteDTO () {

    }

    public Integer getRegistroId() {
        return registroId;
    }

    public void setRegistroId(Integer registroId) {
        this.registroId = registroId;
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


    public String getCep() {
        return cep;
    }


    public void setCep(String cep) {
        this.cep = cep;
    }


    public String getLogradouro() {
        return logradouro;
    }


    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }


    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }


    public String getComplemento() {
        return complemento;
    }


    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }


    public String getBairro() {
        return bairro;
    }


    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getLocalidade() {
        return localidade;
    }


    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }


    public String getUf() {
        return uf;
    }


    public void setUf(String uf) {
        this.uf = uf;
    }
        
}
