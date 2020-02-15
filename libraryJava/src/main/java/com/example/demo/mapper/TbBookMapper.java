package com.example.demo.mapper;

import com.example.demo.entity.TbBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbBookMapper {
    TbBook selectIsbnBook(String isbn);
    List<TbBook> selectAllBook();
    void insertBook(String isbn,String bookName,String author,String press,int bookDate,int bookNumber,int appNumber,int readNumber,String bookUrl,String address);
    void deleteBook(String isbn);
    void updateBook(String isbn,String bookName,String author,String press,int bookDate,int bookNumber,String bookUrl,String address);
    List<TbBook> selectBookNameBook1(String bookName);
    List<TbBook> selectAuthorBook(String author);
    List<TbBook> selectBookNameBook2(String bookName);
}
