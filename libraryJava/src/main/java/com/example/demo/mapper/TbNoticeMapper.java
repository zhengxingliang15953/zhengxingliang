package com.example.demo.mapper;

import com.example.demo.entity.TbNotice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbNoticeMapper {
    void insertNotice(String title,String message,String noticeId);
    void deleteNotice(String noticeId);
    List<TbNotice> selectAll();
    void updateNotice(String title,String message,String noticeId);
}
