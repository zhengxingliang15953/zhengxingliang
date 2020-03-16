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





    List<TbRider> selectAllNumber();
    List<TbRider> selectSnoNumber(String sno);
}
