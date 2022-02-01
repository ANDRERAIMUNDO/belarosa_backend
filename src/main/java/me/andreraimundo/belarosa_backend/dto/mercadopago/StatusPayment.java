package me.andreraimundo.belarosa_backend.dto.mercadopago;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import me.andreraimundo.belarosa_backend.domain.Registro;

@Entity
public class StatusPayment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String id_process;
    private String status;
    private String status_detail;
    private String payment_method_id;
    private String payment_type_id;

    @JsonFormat(pattern="dd/MM/yyyy hh:mm")
    private Date date_approved;

	@JsonIgnore
    @OneToOne
    @JoinColumn(name="processPayment_id")
    private ProcessPayment processPayment;

	@ManyToOne 
    @JoinColumn(name = "registro_id")
    private Registro  registro;
    
    public StatusPayment () {

    }

    public StatusPayment( Registro registro, ProcessPayment processPayment, Integer id, String id_process, String status, String status_detail, String payment_method_id,
            String payment_type_id, Date date_approved) {
		super();
		this.registro = registro;
		this.processPayment = processPayment;
        this.id = id;
        this.id_process = id_process;
        this.status = status;
        this.status_detail = status_detail;
        this.payment_method_id = payment_method_id;
        this.payment_type_id = payment_type_id;
        this.date_approved = date_approved;
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

	public String getPayment_method_id() {
		return payment_method_id;
	}

	public void setPayment_method_id(String payment_method_id) {
		this.payment_method_id = payment_method_id;
	}

	public String getPayment_type_id() {
		return payment_type_id;
	}

	public void setPayment_type_id(String payment_type_id) {
		this.payment_type_id = payment_type_id;
	}

	public Date getDate_approved() {
		return date_approved;
	}

	public void setDate_approved(Date date_approved) {
		this.date_approved = date_approved;
	}

	public ProcessPayment getProcessPayment() {
		return processPayment;
	}

	public void setProcessPayment(ProcessPayment processPayment) {
		this.processPayment = processPayment;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StatusPayment other = (StatusPayment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
        
}