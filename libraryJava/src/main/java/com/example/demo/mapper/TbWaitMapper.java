package com.example.demo.mapper;

import com.example.demo.entity.TbWait;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbWaitMapper {
    List<TbWait> selectSnoWait(String sno);
    List<TbWait> selectIsbnWait(String isbn);
    void insertWait(String waitId,String sno,String isbn,String appTime);
    List<TbWait> selectSnoIsbnWait(String sno,String isbn);
    void deleteWait(String waitId);
    List<TbWait> selectWaitId(String waitId);
}
