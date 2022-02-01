package me.andreraimundo.belarosa_backend.dto.mercadopago;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import me.andreraimundo.belarosa_backend.domain.Registro;

@Entity
public class PixPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String id_process;//analizar tamnahdo de caracter
    private String status;
    private String status_detail;

    @OneToOne(mappedBy = "pixPayment")
    private PixTransactionDetails pixTransactionDetails;

    @OneToOne(mappedBy = "pixPayment")
    private PixPointOfInteraction pixPointOfInteraction;

	@ManyToOne 
    @JoinColumn(name = "registro_id")
    private Registro  registro;
    
    public PixPayment () {

    }

    public PixPayment(Registro registro, Integer id, String id_process, String status, String status_detail) {
        super();
        this.registro = registro;
        this.id = id;
        this.id_process = id_process;
        this.status = status;
        this.status_detail = status_detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getId_process() {
        return id_process;
    }

    public void setId_process(String id_process) {
        this.id_process = id_process;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_detail() {
        return status_detail;
    }

    public void setStatus_detail(String status_detail) {
        this.status_detail = status_detail;
    }

    public PixTransactionDetails getPixTransactionDetails() {
        return pixTransactionDetails;
    }

    public void setPixTransactionDetails(PixTransactionDetails pixTransactionDetails) {
        this.pixTransactionDetails = pixTransactionDetails;
    }

    public PixPointOfInteraction getPixPointOfInteraction() {
        return pixPointOfInteraction;
    }

    public void setPixPointOfInteraction(PixPointOfInteraction pixPointOfInteraction) {
        this.pixPointOfInteraction = pixPointOfInteraction;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
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
        PixPayment other = (PixPayment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    }