package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import me.andreraimundo.belarosa_backend.domain.Categoria;
import me.andreraimundo.belarosa_backend.domain.Descricao;

public class NewProdutoDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo Obrigatorio. ")
    private String name;

    @NotEmpty(message = "Campo Obrigatorio. ")
    private Double price;

    @NotEmpty(message = "Campo Obrigatorio. ")
    List <Descricao> descricoes = new ArrayList<>();

    @NotEmpty(message = "Campo Obrigatorio. ")
    List <Categoria> categorias = new ArrayList<>();

    public NewProdutoDTO () {

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public List<Descricao> getDescricoes() {
        return descricoes;
    }

    public void setDescricoes(List<Descricao> descricoes) {
        this.descricoes = descricoes;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

}
