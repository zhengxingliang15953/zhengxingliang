package com.example.demo.service;

import com.example.demo.entity.TbBook;

import java.util.List;

public interface TbBookService {
    List<TbBook> selectAllBook();
    TbBook selectIsbnBook(String isbn);
    TbBook insertBook(String isbn,String name,String author,String press,String date,Integer number,String bookUrl,String address);
}
