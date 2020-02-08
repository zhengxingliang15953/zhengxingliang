package com.example.demo.mapper;

import com.example.demo.entity.TbStudent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbStudentMapper {
    List<TbStudent> selectAllStudent();

    void updatePwd(String sno,String pwd);

    TbStudent selectOneStudent(String sno);
}
