package com.example.demo.service;

import com.example.demo.entity.TbBook;

import java.util.List;

public interface TbBookService {
    List<TbBook> selectAllBook();
    TbBook selectIsbnBook(String isbn);

}
