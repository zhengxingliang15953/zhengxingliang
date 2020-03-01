package com.example.demo.service;

import com.example.demo.entity.TbAppointment;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TbAppointmentService {
    TbAppointment insertAppointment(String appId, String bookName, String isbn, String studentName, String sno,String appTime);
    List<TbAppointment> selectSnoAppointment(String sno);
    void deleteAppointment(String appId,Integer status);
    List<TbAppointment> selectThreeAppointment(String sno, String isbn, String appTime,Integer start);
    void updateAppointment(String appId,Integer status,String isbn);
}
