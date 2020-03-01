package com.example.demo.mapper;

import com.example.demo.entity.TbAppointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface TbAppointmentMapper {
    void insertAppointment(String appId,String bookName,String isbn,String studentName,String sno,String appTime,Integer lendingNumber);
    List<TbAppointment> selectIfAppointment(String sno, String isbn);
    List<TbAppointment> selectSnoAppointment(String sno);
    void deleteAppointment(String appId);
    List<TbAppointment> selectAllAppointment(RowBounds rowBounds);
    List<TbAppointment> selectThreeAppointment(String sno,String isbn,String appTime,RowBounds rowBounds);
    void updateAppointment(String appId,Integer status);






    List<TbAppointment> selectThreeAppointmentNumber(String sno,String isbn,String appTime);//计数
    List<TbAppointment> selectAllAppointmentNumber();//查询所有计数
}
