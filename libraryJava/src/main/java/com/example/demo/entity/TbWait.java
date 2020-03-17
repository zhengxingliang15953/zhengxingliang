package com.example.demo.entity;

public class TbWait {
    private String waitId;
    private String sno;
    private String isbn;
    private String appTime;
    private Integer status;
    private TbBook tbBook;
    private String appMethods;

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSno() {
        return sno;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getWaitId() {
        return waitId;
    }

    public void setWaitId(String waitId) {
        this.waitId = waitId;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }

    public String getAppTime() {
        return appTime;
    }

    public void setTbBook(TbBook tbBook) {
        this.tbBook = tbBook;
    }

    public TbBook getTbBook() {
        return tbBook;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAppMethods() {
        return appMethods;
    }

    public void setAppMethods(String appMethods) {
        this.appMethods = appMethods;
    }
}
