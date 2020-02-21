package com.example.demo.mapper;

import com.example.demo.entity.TbNotice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface TbNoticeMapper {
    void insertNotice(String title,String message,String noticeId);
    void deleteNotice(String noticeId);
    List<TbNotice> selectAll(RowBounds rowBounds);
    void updateNotice(String title,String message,String noticeId);
    List<TbNotice> selectNumberNotice();
}
