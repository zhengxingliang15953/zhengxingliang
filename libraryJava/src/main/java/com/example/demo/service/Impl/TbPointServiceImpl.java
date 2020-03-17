package com.example.demo.service.Impl;

import com.example.demo.entity.TbAppointment;
import com.example.demo.entity.TbPoint;
import com.example.demo.mapper.TbAppointmentMapper;
import com.example.demo.mapper.TbPointMapper;
import com.example.demo.mapper.TbStudentMapper;
import com.example.demo.service.TbPointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbPointServiceImpl implements TbPointService {

    @Resource
    private TbPointMapper tbPointMapper;

    @Resource
    private TbAppointmentMapper tbAppointmentMapper;

    @Resource
    private TbStudentMapper tbStudentMapper;

    /**
     * 插入指派
     * @param openId
     * @param appId
     * @return
     */
    @Override
    public TbPoint insertPoint(String openId, String appId) {
        TbPoint tbPoint=new TbPoint();
        if(tbPointMapper.selectOpenIdAppId(openId, appId).size()>=1){
            tbPoint.setMsg("0");
            return tbPoint;
        }else{
            tbPoint.setMsg("1");
            tbPointMapper.insertPoint(System.currentTimeMillis()+openId+appId,openId,appId);
            return tbPoint;
        }
    }

    /**
     * 根据openId获取配送单
     * @param openId
     * @return
     */
    @Override
    public List<TbPoint> selectOpenId(String openId) {
        List<TbPoint> tbPointList=tbPointMapper.selectOpenId(openId);
        for(TbPoint tbPoint:tbPointList){
            tbPoint.setTbStudent(tbStudentMapper.selectOneStudent(tbAppointmentMapper.selectAppIdList(tbPoint.getAppId()).get(0).getSno()));
        }
        return tbPointList;
    }
}
