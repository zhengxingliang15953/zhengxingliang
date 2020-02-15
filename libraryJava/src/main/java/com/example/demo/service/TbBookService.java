package com.example.demo.service;

import com.example.demo.entity.TbBook;

import java.util.List;

public interface TbBookService {
    List<TbBook> selectAllBook();
    TbBook selectIsbnBook(String isbn);
    TbBook insertBook(String isbn,String bookName,String author,String press,int bookDate,int bookNumber,String bookUrl,String address);
    void deleteBook(String isbn);
    TbBook updateBook(String isbn,String bookName,String author,String press,int bookDate,int bookNumber,String bookUrl,String address);
    List<TbBook> selectBookNameBook1(String bookName);
    List<TbBook> selectAuthorBook(String author);
    List<TbBook> selectBookNameBook2(String bookName);

}
