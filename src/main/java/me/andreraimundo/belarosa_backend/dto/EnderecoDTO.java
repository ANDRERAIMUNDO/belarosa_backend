package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

public class EnderecoDTO  implements Serializable {

private static final long serialVersionUID = 1L;

private Integer id;
private String cep;
private String logradouro;
private String numero;
private String complemento;
private String bairro;
private String localidade;
private String uf;

public EnderecoDTO () {

}

public EnderecoDTO(Integer id, String cep, String logradouro, String numero, String complemento, String bairro,
        String localidade, String uf) {
    this.id = id;
    this.cep = cep;
    this.logradouro = logradouro;
    this.numero = numero;
    this.complemento = complemento;
    this.bairro = bairro;
    this.localidade = localidade;
    this.uf = uf;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
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


