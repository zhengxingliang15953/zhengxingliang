package com.example.demo.service;

import com.example.demo.entity.TbNotice;

import java.util.List;

public interface TbNoticeService {

    void insertNotice(String title,String message,String noticeId);
    void deleteNotice(String noticeId);
    List<TbNotice> selectAll(Integer start);
    void updateNotice(String title,String message,String noticeId);
}
