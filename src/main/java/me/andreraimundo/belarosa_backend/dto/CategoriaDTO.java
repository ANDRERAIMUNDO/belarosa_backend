package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import me.andreraimundo.belarosa_backend.domain.Categoria;

public class CategoriaDTO  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Campo Obrigatorio. ")
    @Size(min = 5,message = "Minimo 8 caracter. " )
    @Size(max = 25,message = "Maximo 25 caracter. " )
    private String name;

    public CategoriaDTO () {

    }

    public CategoriaDTO (Categoria obj) {
        id =obj.getId();
        name = obj.getName();
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
