package com.example.demo.service;

import com.example.demo.entity.TbBook;

import java.util.List;

public interface TbBookService {
    List<TbBook> selectAllBook(String isbn,Integer start);
    List<TbBook> selectIsbnBook(String isbn);
    TbBook insertBook(String isbn,String bookName,String author,String press,int bookDate,int bookNumber,String bookUrl,String address);
    TbBook deleteBook(String isbn);
    TbBook updateBook(String isbn,String bookName,String author,String press,int bookDate,int bookNumber,String bookUrl,String address);
    List<TbBook> selectBookNameBook1(String bookName,Integer start);
    List<TbBook> selectAuthorBook(String author,Integer start);
    List<TbBook> selectBookNameBook2(String bookName,Integer start);
    void updateBookType(String isbn,Integer type);
}
