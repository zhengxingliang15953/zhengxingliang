package com.example.demo.entity;

public class TbBook {
    private String isbn;
    private String bookName;
    private String author;
    private String press;
    private int bookDate;
    private String bookUrl;
    private int bookNumber;
    private int appNumber;
    private int readNumber;
    private String address;
    private String msg;



    public int getAppNumber() {
        return appNumber;
    }

    public int getReadNumber() {
        return readNumber;
    }

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

    public void setAppNumber(int appNumber) {
        this.appNumber = appNumber;
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

    public void setReadNumber(int readNumber) {
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

    public int getBookDate() {
        return bookDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookDate(int bookDate) {
        this.bookDate = bookDate;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }
}
