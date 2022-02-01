package me.andreraimundo.belarosa_backend.dto.mercadopago;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StatusPaymentDTO {
    private Integer id;
    private String id_process;
    private String status;
    private String status_detail;
    private String payment_method_id;
    private String payment_type_id;

    @JsonFormat(pattern="dd/MM/yyyy hh:mm")
    private Date date_approved;

    public StatusPaymentDTO () {

    }

    public StatusPaymentDTO (StatusPayment obj) {
        id = obj.getId();
        id_process = obj.getId_process();
        status = obj.getStatus();
        status_detail = obj.getStatus_detail();
        payment_method_id = obj.getPayment_method_id();
        payment_type_id = obj.getPayment_type_id();
        date_approved = obj.getDate_approved();
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
    
    
}
