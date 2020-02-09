package com.example.demo.mapper;

import com.example.demo.entity.TbBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbBookMapper {
    TbBook selectIsbnBook(String isbn);
    List<TbBook> selectAllBook();
}
