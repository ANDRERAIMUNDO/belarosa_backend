package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailForgotPasswordDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Campo obrigatorio. ")
    @Email(message = "Email em formato invalido. ")
    private String email;

    public EmailForgotPasswordDTO () {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
