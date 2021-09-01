package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class DescricaoDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;

    @Size(max = 750, message = "Limite de caracteres atingido. ")
    private String name;

    public DescricaoDTO() {

    }

    public DescricaoDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
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
    
}