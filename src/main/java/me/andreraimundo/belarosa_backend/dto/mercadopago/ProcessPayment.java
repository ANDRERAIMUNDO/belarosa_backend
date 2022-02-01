package me.andreraimundo.belarosa_backend.dto.mercadopago;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ProcessPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double transaction_amount;
    private String token;
    private String  description;
    private Integer installments;
    private String payment_method_id;
    private Integer issuer_id;

	@OneToMany(mappedBy = "processPayment", cascade = CascadeType.ALL)
    private List <PayerUser> payers = new ArrayList<>();

    @OneToOne(mappedBy = "processPayment")
    private StatusPayment statusPayment;
	
    public ProcessPayment () {

    }

	public ProcessPayment(Integer id, Double transaction_amount, String token, String description, Integer installments,
			String payment_method_id, Integer issuer_id) {
		super();
		this.id = id;
		this.transaction_amount = transaction_amount;
		this.token = token;
		this.description = description;
		this.installments = installments;
		this.payment_method_id = payment_method_id;
		this.issuer_id = issuer_id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(Double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

	public String getPayment_method_id() {
		return payment_method_id;
	}

	public void setPayment_method_id(String payment_method_id) {
		this.payment_method_id = payment_method_id;
	}

	public Integer getIssuer_id() {
		return issuer_id;
	}

	public void setIssuer_id(Integer issuer_id) {
		this.issuer_id = issuer_id;
	}

	public List<PayerUser> getPayers() {
		return payers;
	}

	public void setPayers(List<PayerUser> payers) {
		this.payers = payers;
	}

	public StatusPayment getStatusPayment() {
		return statusPayment;
	}

	public void setStatusPayment(StatusPayment statusPayment) {
		this.statusPayment = statusPayment;
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
        ProcessPayment other = (ProcessPayment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
