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
public class PixTransactionDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double net_received_amount;
    private Double total_paid_amount;
    private Double overpaid_amount;
    private String external_resource_url;
    private Double installment_amount;
    private String financial_institution;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="pixPayment_id")
    private PixPayment  pixPayment;

    public PixTransactionDetails () {

    }

    public PixTransactionDetails(Integer id, Double net_received_amount, Double total_paid_amount,
            Double overpaid_amount, String external_resource_url, Double installment_amount,
            String financial_institution, PixPayment pixPayment) {
        this.id = id;
        this.net_received_amount = net_received_amount;
        this.total_paid_amount = total_paid_amount;
        this.overpaid_amount = overpaid_amount;
        this.external_resource_url = external_resource_url;
        this.installment_amount = installment_amount;
        this.financial_institution = financial_institution;
        this.pixPayment = pixPayment;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNet_received_amount() {
        return net_received_amount;
    }

    public void setNet_received_amount(Double net_received_amount) {
        this.net_received_amount = net_received_amount;
    }

    public Double getTotal_paid_amount() {
        return total_paid_amount;
    }

    public void setTotal_paid_amount(Double total_paid_amount) {
        this.total_paid_amount = total_paid_amount;
    }

    public Double getOverpaid_amount() {
        return overpaid_amount;
    }

    public void setOverpaid_amount(Double overpaid_amount) {
        this.overpaid_amount = overpaid_amount;
    }

    public String getExternal_resource_url() {
        return external_resource_url;
    }

    public void setExternal_resource_url(String external_resource_url) {
        this.external_resource_url = external_resource_url;
    }

    public Double getInstallment_amount() {
        return installment_amount;
    }

    public void setInstallment_amount(Double installment_amount) {
        this.installment_amount = installment_amount;
    }

    public String getFinancial_institution() {
        return financial_institution;
    }

    public void setFinancial_institution(String financial_institution) {
        this.financial_institution = financial_institution;
    }

    public PixPayment getPixPayment() {
        return pixPayment;
    }

    public void setPixPayment(PixPayment pixPayment) {
        this.pixPayment = pixPayment;
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
        PixTransactionDetails other = (PixTransactionDetails) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
