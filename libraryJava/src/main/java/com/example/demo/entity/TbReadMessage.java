package com.example.demo.entity;

public class TbReadMessage {
    private String sno;
    private String message;
    private String readId;
    private Integer status;

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getMessage() {
        return message;
    }

    public String getSno() {
        return sno;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReadId() {
        return readId;
    }

    public void setReadId(String readId) {
        this.readId = readId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
