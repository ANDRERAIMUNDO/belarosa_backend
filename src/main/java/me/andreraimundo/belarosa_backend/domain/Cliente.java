package me.andreraimundo.belarosa_backend.domain;

import java.io.Serializable;

public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;
    private Integer cpf;
    private Integer dateNasc;
    private Integer phone;

    public Cliente (){

    }

    public Cliente(Integer id, String name, Integer cpf, Integer dateNasc, Integer phone) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.dateNasc = dateNasc;
        this.phone = phone;
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
    public Integer getCpf() {
        return cpf;
    }
    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }
    public Integer getDateNasc() {
        return dateNasc;
    }
    public void setDateNasc(Integer dateNasc) {
        this.dateNasc = dateNasc;
    }
    public Integer getPhone() {
        return phone;
    }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
