package com.example.demo.mapper;

import com.example.demo.entity.TbNotice;

import java.util.List;

public interface TbNoticeMapper {
    void insertNotice(String title,String message,String noticeId);
    void deleteNotice(String noticeId);
    List<TbNotice> selectAll();
    void updateNotice(String title,String message,String noticeId);
}
