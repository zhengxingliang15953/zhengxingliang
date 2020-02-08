package com.example.demo.mapper;

import com.example.demo.entity.TbReadMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbReadMessageMapper {
    List<TbReadMessage> selectAllReadMessage();
    void insertReadMessage(String sno,String message,String readId);
    void deleteReadMessage(String readId);
    List<TbReadMessage> selectOneReadMessage(String sno);

}
