package me.andreraimundo.belarosa_backend.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class UpdatePassowordDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo obrigatorio. ")
    private String password;

    public UpdatePassowordDTO () {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
