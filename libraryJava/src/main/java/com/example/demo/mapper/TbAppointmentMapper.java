package com.example.demo.mapper;

import com.example.demo.entity.TbAppointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface TbAppointmentMapper {
    void insertAppointment(String appId,String bookName,String isbn,String studentName,String sno,String appTime,Integer status,Integer lendingNumber,String appMethods);
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
    List<TbAppointment> deleteBookShow(String isbn);
    List<TbAppointment> selectDeleteList(Integer status,String appId);
    List<TbAppointment> selectAppIdList(String appId);
    void updateLendingTime(String appId,String lendingTime);
    List<TbAppointment> selectSchedule(Integer status);
    List<TbAppointment> selectAllAfter(RowBounds rowBounds);
    List<TbAppointment> selectSnoAfter(String sno,RowBounds rowBounds);
    List<TbAppointment> selectAppTimeAfter(String appTime,RowBounds rowBounds);
    void updateAfter(String appId,Integer status);
    List<TbAppointment> selectWaitDesignation(RowBounds rowBounds);
    List<TbAppointment> selectSnoWaitDesignation(String sno,RowBounds rowBounds);





    List<TbAppointment> selectAppTimeNumber(String appTime);//appTime计数
    List<TbAppointment> selectAllAppointmentNumber();//查询所有计数
    List<TbAppointment> selectAllBackBookNumber();//归还列表计数
    List<TbAppointment> selectSnoBackBookNumber(String sno);//sno归还计数
    List<TbAppointment> selectAppTimeBackBookNumber(String appTime);//appTime计数
    List<TbAppointment> selectAllBackingBookNumber();//查询所有已归还计数
    List<TbAppointment> selectSnoBackingNumberBook(String sno);//查询sno已归还计数
    List<TbAppointment> selectBackTimeBackingBookNumber(String backTime);//查询backTime已归还计数
    List<TbAppointment> selectAllAfterNumber();//查询预约预期所有列表计数
    List<TbAppointment> selectSnoAfterNumber(String sno);//查询sno预约预期计数
    List<TbAppointment> selectAppTimeAfterNumber(String appTime);//查询appTime预约计数
    List<TbAppointment> selectWaitDesignationNumber();//查询待指派列表计数
    List<TbAppointment> selectSnoWaitDesignationNumber(String sno);//查询sno待指派计数
}
