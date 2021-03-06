package com.example.demo.mapper;

import com.example.demo.entity.TbStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import java.util.List;

@Mapper
public interface TbStudentMapper {
    List<TbStudent> selectAllStudent(RowBounds rowBounds);
    List<TbStudent> selectNumberStudent();
    void updatePwd(String sno,String pwd);

    TbStudent selectOneStudent(String sno);

    List<TbStudent> selectSnoStudent(String sno);
}
