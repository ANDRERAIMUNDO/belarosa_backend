package me.andreraimundo.belarosa_backend.dto.mercadopago;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;

@Entity
public class PixTransactionData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="CONTENT", length=10000)
    private String qr_code_base64;
    
   // @Column(name="CONTENT", length=1000)
    private String qr_code;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="pixPointOfInteraction_id")
    private PixPointOfInteraction pixPointOfInteraction;

    public PixTransactionData() {

    }

    public PixTransactionData(Integer id, String qr_code_base64, String qr_code,
            PixPointOfInteraction pixPointOfInteraction) {
        this.id = id;
        this.qr_code_base64 = qr_code_base64;
        this.qr_code = qr_code;
        this.pixPointOfInteraction = pixPointOfInteraction;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQr_code_base64() {
		return qr_code_base64;
	}

	public void setQr_code_base64(String qr_code_base64) {
		this.qr_code_base64 = qr_code_base64;
	}

	public String getQr_code() {
		return qr_code;
	}

	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}

	public PixPointOfInteraction getPixPointOfInteraction() {
		return pixPointOfInteraction;
	}

	public void setPixPointOfInteraction(PixPointOfInteraction pixPointOfInteraction) {
		this.pixPointOfInteraction = pixPointOfInteraction;
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
        PixTransactionData other = (PixTransactionData) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
