package me.andreraimundo.belarosa_backend.dto.mercadopago;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PixPointOfInteraction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;
    private String sub_type;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="pixPayment_id")
    private PixPayment pixPayment;

    @OneToOne(mappedBy = "pixPointOfInteraction")
    private PixApplicationData pixApplicationData;

    @OneToOne(mappedBy = "pixPointOfInteraction")
    private PixTransactionData pixTransactionData;

    public PixPointOfInteraction () {
        
    }

    public PixPointOfInteraction(Integer id, String type, String sub_type, PixPayment pixPayment) {
        this.id = id;
        this.type = type;
        this.sub_type = sub_type;
        this.pixPayment = pixPayment;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSub_type() {
		return sub_type;
	}

	public void setSub_type(String sub_type) {
		this.sub_type = sub_type;
	}

	public PixPayment getPixPayment() {
		return pixPayment;
	}

	public void setPixPayment(PixPayment pixPayment) {
		this.pixPayment = pixPayment;
	}

	public PixApplicationData getPixApplicationData() {
		return pixApplicationData;
	}

	public void setPixApplicationData(PixApplicationData pixApplicationData) {
		this.pixApplicationData = pixApplicationData;
	}

	public PixTransactionData getPixTransactionData() {
		return pixTransactionData;
	}

	public void setPixTransactionData(PixTransactionData pixTransactionData) {
		this.pixTransactionData = pixTransactionData;
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
        PixPointOfInteraction other = (PixPointOfInteraction) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
