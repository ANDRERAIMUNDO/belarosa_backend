package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class NewRegistroDTO  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;

  
    @NotEmpty(message = "Campo obrigatorio. ")
    @Email(message = "Email em formato invalido. ")
    private String email;

    @NotEmpty(message = "Campo obrigatorio. ")
    private String password;

    private Integer tipoUsuario;

    public NewRegistroDTO () {
        
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
