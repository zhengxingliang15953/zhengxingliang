package com.example.demo.mapper;

import com.example.demo.entity.TbAppointment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbAppointmentMapper {
    void insertAppointment(String appId,String bookName,String isbn,String studentName,String sno,String appTime,Integer lendingNumber);
    List<TbAppointment> selectIfAppointment(String sno, String isbn);
}
