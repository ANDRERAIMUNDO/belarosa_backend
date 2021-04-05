package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
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
    @Email(message = "Email em formato invalido. ")
    private String email;

    public ClienteDTO () {

    }

    public ClienteDTO ( Cliente obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getRegistro().getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
