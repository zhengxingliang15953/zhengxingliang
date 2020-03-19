package com.example.demo.service.Impl;

import com.example.demo.entity.TbAppointment;
import com.example.demo.entity.TbPoint;
import com.example.demo.mapper.*;
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

    @Resource
    private TbBookMapper tbBookMapper;

    @Resource
    private TbRiderMapper tbRiderMapper;

    @Resource
    private TbAppointmentServiceImpl tbAppointmentService;

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
            tbPoint.setTbBook(tbBookMapper.selectIsbnBook(tbAppointmentMapper.selectAppIdList(tbPoint.getAppId()).get(0).getIsbn()).get(0));
        }
        return tbPointList;
    }

    /**
     * 根据openId获取取货单
     * @param openId
     * @return
     */
    @Override
    public List<TbPoint> selectHavePointId(String openId) {
        List<TbPoint> tbPointList=tbPointMapper.selectOpenIdStatus(openId,8);
        for(TbPoint tbPoint1:tbPointList){
            tbPoint1.setTbStudent(tbStudentMapper.selectOneStudent(tbAppointmentMapper.selectAppIdList(tbPoint1.getAppId()).get(0).getSno()));
            tbPoint1.setTbBook(tbBookMapper.selectIsbnBook(tbAppointmentMapper.selectAppIdList(tbPoint1.getAppId()).get(0).getIsbn()).get(0));
        }
        return tbPointList;
    }

    /**
     * 根据openId获取待送达单
     * @param openId
     * @return
     */
    @Override
    public List<TbPoint> selectWaitFinish(String openId) {
        List<TbPoint> tbPointList=tbPointMapper.selectOpenIdStatus(openId,9);
        for(TbPoint tbPoint1:tbPointList){
            tbPoint1.setTbStudent(tbStudentMapper.selectOneStudent(tbAppointmentMapper.selectAppIdList(tbPoint1.getAppId()).get(0).getSno()));
            tbPoint1.setTbBook(tbBookMapper.selectIsbnBook(tbAppointmentMapper.selectAppIdList(tbPoint1.getAppId()).get(0).getIsbn()).get(0));
        }
        return tbPointList;
    }

    /**
     * 获取历史订单
     * @param openId
     * @return
     */
    @Override
    public List<TbPoint> selectHistory(String openId) {
        List<TbPoint> tbPointList=tbPointMapper.selectOpenIdStatus(openId,3);
        for(TbPoint tbPoint1:tbPointList){
            tbPoint1.setTbStudent(tbStudentMapper.selectOneStudent(tbAppointmentMapper.selectAppIdList(tbPoint1.getAppId()).get(0).getSno()));
            tbPoint1.setTbBook(tbBookMapper.selectIsbnBook(tbAppointmentMapper.selectAppIdList(tbPoint1.getAppId()).get(0).getIsbn()).get(0));
        }
        return tbPointList;
    }

    /**
     * 骑手同意接单
     * @param appId
     * @return
     */
    @Override
    public TbPoint agreeOrder(String appId,String openId,String pointId) {
        TbPoint tbPoint=new TbPoint();
        if(tbAppointmentMapper.selectAppIdList(appId).get(0).getStatus()!=6){
            tbPoint.setMsg("0");
            return tbPoint;
        }else if(tbPointMapper.selectAppAll(appId,6).size()<=0){
            tbPoint.setMsg("0");
            return tbPoint;
        }else{
            tbAppointmentMapper.updateAfter(appId,8);
            tbPointMapper.deletePoint(appId, openId);
            tbPointMapper.agreePoint(pointId,8);
            tbPoint.setMsg("1");
            return tbPoint;
        }
    }

    /**
     * 骑手完成取货
     * @param pointId
     * @param appId
     */
    @Override
    public void finishTake(String pointId, String appId) {
        tbPointMapper.agreePoint(pointId,9);
        tbAppointmentMapper.updateAfter(appId,9);
    }

    /**
     * 骑手完成订单
     * @param pointId
     * @param appId
     */
    @Override
    public void finishOrder(String pointId, String appId,String openId) {
        tbPointMapper.agreePoint(pointId,3);
        //tbAppointmentMapper.updateAfter(appId,3);
        tbAppointmentMapper.updateAppointment(appId,3,tbAppointmentService.getTime());
        Integer orderNumber=tbRiderMapper.selectOpenId(openId).get(0).getOrderNumber();
        orderNumber++;
        tbRiderMapper.updateNumber(openId,orderNumber);
    }
}
