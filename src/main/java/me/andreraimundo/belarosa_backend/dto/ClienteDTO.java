package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import me.andreraimundo.belarosa_backend.domain.Cliente;

public class ClienteDTO  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    @NotEmpty(message = "Campo obrigatorio. ")
    @Size(min = 10, message = "Minimo 10 caracteres. ")
    @Size(max = 40, message = "Maximo 40 caracteres. ")
    private String name;

    @NotEmpty(message = "Campo obrigatorio. ")
    private String phone;

    public ClienteDTO () {

    }

    public ClienteDTO ( Cliente obj) {
        id = obj.getId();
        name = obj.getName();
        phone = obj.getPhone();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
