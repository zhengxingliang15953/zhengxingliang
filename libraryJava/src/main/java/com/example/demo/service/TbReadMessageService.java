package com.example.demo.service;

import com.example.demo.entity.TbReadMessage;

import java.util.List;

public interface TbReadMessageService {
    List<TbReadMessage> selectAllReadMessage();
    void insertReadMessage(String sno,String message,String readId);
    void deleteReadMessage(String readId);
    List<TbReadMessage> selectOneReadMessage(String sno);
}
