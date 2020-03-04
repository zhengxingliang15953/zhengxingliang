package com.example.demo.service;

import com.example.demo.entity.TbAppointment;
import org.apache.ibatis.session.RowBounds;

import java.text.ParseException;
import java.util.List;

public interface TbAppointmentService {
    TbAppointment insertAppointment(String appId, String bookName, String isbn, String studentName, String sno,String appTime);
    List<TbAppointment> selectSnoAppointment(String sno);
    TbAppointment deleteAppointment(String appId,Integer status);
    List<TbAppointment> selectThreeAppointment(String sno, String appTime,Integer start);
    void updateAppointment(String appId,Integer status,String isbn);
    void updateBackBook(String appId,String isbn);
    List<TbAppointment> selectBackBook(String sno,String appTime,Integer start);
    List<TbAppointment> selectBackingBook(String sno,String backTime,Integer start);
    TbAppointment continueBrow(String appId,String isbn) throws ParseException;
}
