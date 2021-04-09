package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import me.andreraimundo.belarosa_backend.domain.Registro;

public class RegistroDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo obrigatorio. ")
    @Email(message = "Email em formato invalido. ")
    private String email;

    public RegistroDTO () {

    }

    public RegistroDTO (Registro obj ) {
        id = obj.getId();
        email = obj.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
