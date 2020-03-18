package com.example.demo.mapper;

import com.example.demo.entity.TbRider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface TbRiderMapper {
    void insertId(String openId);
    List<TbRider> selectOpenId(String openId);
    void apply(String openId,String studentName,String sno);
    List<TbRider> selectAll(RowBounds rowBounds);
    List<TbRider> selectSno(String sno, RowBounds rowBounds);
    void updateStatus(String openId,Integer status);
    void deleteRider(String openId);
    List<TbRider> selectOnlineRider(Integer status);
    List<TbRider> selectAllRider(RowBounds rowBounds);
    List<TbRider> selectAllSnoRider(String sno,RowBounds rowBounds);
    void updateNumber(String openId,Integer orderNumber);




    List<TbRider> selectAllNumber();
    List<TbRider> selectSnoNumber(String sno);
    List<TbRider> selectAllRiderNumber();
    List<TbRider> selectAllSnoRiderNumber(String sno);
}
