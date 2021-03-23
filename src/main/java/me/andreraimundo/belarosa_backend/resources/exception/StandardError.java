package me.andreraimundo.belarosa_backend.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String msg;
    private Long timeSpamp;

    public StandardError(Integer status, String msg, Long timeSpamp) {
        
        this.status = status;
        this.msg = msg;
        this.timeSpamp = timeSpamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimeSpamp() {
        return timeSpamp;
    }

    public void setTimeSpamp(Long timeSpamp) {
        this.timeSpamp = timeSpamp;
    }
    
}
