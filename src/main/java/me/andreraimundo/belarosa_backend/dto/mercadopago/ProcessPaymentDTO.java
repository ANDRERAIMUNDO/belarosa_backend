package me.andreraimundo.belarosa_backend.dto.mercadopago;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProcessPaymentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Integer registroId;
	
	private Integer id;
    private Double transaction_amount;
    private String token;
    private String description;
    private Integer installments;
    private String payment_method_id;
    private Integer issuer_id;
    private String email;

	private String response_id_process; 
	private String responseStatus; 
	private String responseStatusDetail; 
	private String responsePaymentMethodId;
	private String responsePaymentTypeId; 

	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private Date responseDateApproved;
	
    public ProcessPaymentDTO () {

    }
	
	public Integer getRegistroId() {
		return registroId;
	}

	public void setRegistroId(Integer registroId) {
		this.registroId = registroId;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponse_id_process() {
		return response_id_process;
	}

	public void setResponse_id_process(String response_id_process) {
		this.response_id_process = response_id_process;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseStatusDetail() {
		return responseStatusDetail;
	}

	public void setResponseStatusDetail(String responseStatusDetail) {
		this.responseStatusDetail = responseStatusDetail;
	}

	public String getResponsePaymentMethodId() {
		return responsePaymentMethodId;
	}

	public void setResponsePaymentMethodId(String responsePaymentMethodId) {
		this.responsePaymentMethodId = responsePaymentMethodId;
	}

	public String getResponsePaymentTypeId() {
		return responsePaymentTypeId;
	}

	public void setResponsePaymentTypeId(String responsePaymentTypeId) {
		this.responsePaymentTypeId = responsePaymentTypeId;
	}

	public Date getResponseDateApproved() {
		return responseDateApproved;
	}

	public void setResponseDateApproved(Date responseDateApproved) {
		this.responseDateApproved = responseDateApproved;
	}

}