package com.example.demo.mapper;

import com.example.demo.entity.TbBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface TbBookMapper {
    List<TbBook> selectIsbnBook(String isbn);
    List<TbBook> selectAllBook(RowBounds rowBounds);
    void insertBook(String isbn,String bookName,String author,String press,int bookDate,int bookNumber,int appNumber,int readNumber,String bookUrl,String address);
    void deleteBook(String isbn);
    void updateBook(String isbn,String bookName,String author,String press,int bookDate,int bookNumber,String bookUrl,String address);
    List<TbBook> selectBookNameBook1(String bookName,RowBounds rowBounds);
    List<TbBook> selectAuthorBook(String author,RowBounds rowBounds);
    List<TbBook> selectBookNameBook2(String bookName,RowBounds rowBounds);
    void updateReadLend(String isbn,Integer appNumber,Integer readNumber);
    void updateBookType(String isbn,Integer type);

    List<TbBook> selectAllJiShu();
    List<TbBook> selectBook1Number(String bookName);
    List<TbBook> selectBook2Number(String bookName);
    List<TbBook> selectAuthorNumber(String author);
}
