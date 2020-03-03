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
    void updateAppointment(String appId,Integer status,String lendTime);
    List<TbAppointment> selectSno(String sno,RowBounds rowBounds);
    List<TbAppointment> selectAppTime(String appTime,RowBounds rowBounds);
    void updateBackBook(String appId,String backTime);
    List<TbAppointment> selectAllBackBookList(RowBounds rowBounds);
    List<TbAppointment> selectSnoBackBook(String sno,RowBounds rowBounds);
    List<TbAppointment> selectAppTimeBackBook(String appTime,RowBounds rowBounds);
    List<TbAppointment> selectAllBackingBook(RowBounds rowBounds);
    List<TbAppointment> selectSnoBackingBook(String sno,RowBounds rowBounds);
    List<TbAppointment> selectBackTimeBackingBook(String backTime,RowBounds rowBounds);




    List<TbAppointment> selectAppTimeNumber(String appTime);//appTime计数
    List<TbAppointment> selectAllAppointmentNumber();//查询所有计数
    List<TbAppointment> selectAllBackBookNumber();//归还列表计数
    List<TbAppointment> selectSnoBackBookNumber(String sno);//sno归还计数
    List<TbAppointment> selectAppTimeBackBookNumber(String appTime);//appTime计数
    List<TbAppointment> selectAllBackingBookNumber();//查询所有已归还计数
    List<TbAppointment> selectSnoBackingNumberBook(String sno);//查询sno已归还计数
    List<TbAppointment> selectBackTimeBackingBookNumber(String backTime);//查询backTime已归还计数
}
