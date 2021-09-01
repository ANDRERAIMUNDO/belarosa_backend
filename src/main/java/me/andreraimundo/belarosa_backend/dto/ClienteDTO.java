package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import me.andreraimundo.belarosa_backend.domain.Cliente;

public class ClienteDTO  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;

    @NotEmpty(message = "Campo obrigatorio. ")
    @Size(max = 11, message = "Maximo 11 caracteres. ")
    private String phone;

    public ClienteDTO () {

    }

    public ClienteDTO ( Cliente obj) {
        id = obj.getId();
        phone = obj.getPhone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
