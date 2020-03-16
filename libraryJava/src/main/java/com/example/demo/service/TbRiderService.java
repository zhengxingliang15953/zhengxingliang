package com.example.demo.service;

import com.example.demo.entity.TbRider;

import java.util.List;

public interface TbRiderService {
    void insertId(String openId);
    TbRider apply(String openId, String studentName, String sno);
    List<TbRider> selectApply(String sno,Integer start);
}
