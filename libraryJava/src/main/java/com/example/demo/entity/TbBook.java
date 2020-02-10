package com.example.demo.entity;

public class TbBook {
    private String isbn;
    private String name;
    private String author;
    private String press;
    private String date;
    private String bookUrl;
    private Integer number;
    private Integer appNumber;
    private Integer readNumber;
    private String address;
    private String msg;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAppNumber() {
        return appNumber;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getReadNumber() {
        return readNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public String getData() {
        return date;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPress() {
        return press;
    }

    public void setAppNumber(Integer appNumber) {
        this.appNumber = appNumber;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public void setData(String date) {
        this.date = date;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public void setReadNumber(Integer readNumber) {
        this.readNumber = readNumber;
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
}
