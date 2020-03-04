package com.example.demo.entity;

public class TbBook {
    private String isbn;
    private String bookName;
    private String author;
    private String press;
    private Integer bookDate;
    private String bookUrl;
    private Integer bookNumber;
    private Integer appNumber;
    private Integer readNumber;
    private String address;
    private String msg;
    private Integer status;
    private Integer type;


    public String getAuthor() {
        return author;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPress() {
        return press;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPress(String press) {
        this.press = press;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }


    public String getBookName() {
        return bookName;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }

    public void setBookDate(Integer bookDate) {
        this.bookDate = bookDate;
    }

    public void setReadNumber(Integer readNumber) {
        this.readNumber = readNumber;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setAppNumber(Integer appNumber) {
        this.appNumber = appNumber;
    }

    public Integer getReadNumber() {
        return readNumber;
    }

    public Integer getAppNumber() {
        return appNumber;
    }

    public Integer getType() {
        return type;
    }

    public Integer getBookDate() {
        return bookDate;
    }
}
