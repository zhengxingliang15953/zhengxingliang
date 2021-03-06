package com.example.demo.entity;

import java.util.List;

public class TbAppointment {
    private String appId;
    private String bookName;
    private String isbn;
    private String studentName;
    private String sno;
    private String appTime;
    private String lendTime;
    private String backTime;
    private String lendingTime;
    private Integer status;
    private Integer lendingNumber;
    private String msg;
    private String appMethods;
    private TbBook tbBook;
    private List<TbWait> tbWaitList;
    private TbRider tbRider;
    private Integer lendingTimeNumber;

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }


    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppTime() {
        return appTime;
    }

    public String getBackTime() {
        return backTime;
    }

    public String getLendingTime() {
        return lendingTime;
    }

    public String getLendTime() {
        return lendTime;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setAppTime(String appTime) {
        this.appTime = appTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }

    public void setLendingTime(String lendingTime) {
        this.lendingTime = lendingTime;
    }

    public void setLendTime(String lendTime) {
        this.lendTime = lendTime;
    }

    public Integer getLendingNumber() {
        return lendingNumber;
    }

    public void setLendingNumber(Integer lendingNumber) {
        this.lendingNumber = lendingNumber;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStudentName() {
        return studentName;
    }

    public TbBook getTbBook() {
        return tbBook;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setTbBook(TbBook tbBook) {
        this.tbBook = tbBook;
    }

    public List<TbWait> getTbWaitList() {
        return tbWaitList;
    }

    public void setTbWaitList(List<TbWait> tbWaitList) {
        this.tbWaitList = tbWaitList;
    }

    public Integer getLendingTimeNumber() {
        return lendingTimeNumber;
    }

    public void setLendingTimeNumber(Integer lendingTimeNumber) {
        this.lendingTimeNumber = lendingTimeNumber;
    }

    public void setAppMethods(String appMethods) {
        this.appMethods = appMethods;
    }

    public String getAppMethods() {
        return appMethods;
    }

    public void setTbRider(TbRider tbRider) {
        this.tbRider = tbRider;
    }

    public TbRider getTbRider() {
        return tbRider;
    }
}
