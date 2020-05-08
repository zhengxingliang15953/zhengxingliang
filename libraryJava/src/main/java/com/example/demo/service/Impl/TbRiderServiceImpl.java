package com.example.demo.service.Impl;

import com.example.demo.entity.TbPoint;
import com.example.demo.entity.TbRider;
import com.example.demo.mapper.TbPointMapper;
import com.example.demo.mapper.TbRiderMapper;
import com.example.demo.service.TbRiderService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbRiderServiceImpl implements TbRiderService {

    @Resource
    private TbRiderMapper tbRiderMapper;

    @Resource
    private TbPointMapper tbPointMapper;
    /**
     * 用户登录添加账号
     * @param openId
     */
    @Override
    public void insertId(String openId) {
        if(tbRiderMapper.selectOpenId(openId).size()<=0){
            tbRiderMapper.insertId(openId);
        }
    }

    /**
     * 申请骑手
     * @param openId
     * @param studentName
     * @param sno
     * @return
     */
    @Override
    public TbRider apply(String openId, String studentName, String sno) {
        TbRider tbRider=new TbRider();
        List<TbRider> tbRiderList=tbRiderMapper.selectOpenId(openId);
//        System.out.println(tbPointMapper.selectOpenId(openId).size());
        if(tbRiderList.size()<=0){
            insertId(openId);
            tbRiderMapper.apply(openId, studentName, sno,tbPointMapper.selectAllOpenId(openId).size());

            tbRider.setMsg("1");
            return tbRider;
        }else if(tbRiderList.get(0).getStatus()==2){
            tbRider.setMsg("2");
            return tbRider;
        }else{
            tbRider.setMsg("3");
            return tbRider;
        }
    }

    /**
     * 查询骑手申请列表
     * @param sno
     * @param start
     * @return
     */
    @Override
    public List<TbRider> selectApply(String sno, Integer start) {
        List<TbRider> tbRiderList=null;
        if(sno.equals("")){
            tbRiderList=tbRiderMapper.selectAll(new RowBounds((start-1)*10,10));
            if(tbRiderList.size()<=0){
                TbRider tbRider=new TbRider();
                tbRider.setMsg("0");
                tbRiderList.add(tbRider);
            }else{
                tbRiderList.get(0).setMsg(tbRiderMapper.selectAllNumber().size()+"");
            }
            return tbRiderList;
        }else{
            tbRiderList=tbRiderMapper.selectSno(sno,new RowBounds((start-1)*10,10));
            if(tbRiderList.size()<=0){
                TbRider tbRider=new TbRider();
                tbRider.setMsg("0");
                tbRiderList.add(tbRider);
            }else{
                tbRiderList.get(0).setMsg(tbRiderMapper.selectSnoNumber(sno).size()+"");
            }
            return tbRiderList;
        }
    }


    /**
     * 审批通过
     * @param openId
     * @param status
     * @return
     */
    @Override
    public TbRider agreement(String openId, Integer status) {
        TbRider tbRider=new TbRider();
        if(tbRiderMapper.selectOpenId(openId).get(0).getStatus()==2){
            tbRiderMapper.updateStatus(openId, status);
            tbRider.setMsg("1");
            return tbRider;
        }else{
            tbRider.setMsg("0");
        }
        return tbRider;
    }

    /**
     * 根据OpenId获取用户信息
     * @param openId
     * @return
     */
    @Override
    public TbRider selectOpenId(String openId) {
        TbRider tbRider=new TbRider();
        List<TbRider> tbRiderList=tbRiderMapper.selectOpenId(openId);
        if(tbRiderList.size()<=0){
            tbRider.setMsg("0");
            return tbRider;
        }else{
            tbRider=tbRiderList.get(0);
            tbRider.setMsg("1");
            return tbRider;
        }
    }

    /**
     * 审批不通过
     * @param openId
     * @return
     */
    @Override
    public TbRider refuse(String openId) {
        TbRider tbRider=new TbRider();
        List<TbRider> tbRiderList=tbRiderMapper.selectOpenId(openId);
        if(tbRiderList.size()<=0){
            tbRider.setMsg("0");
            return tbRider;//已被其他管理员拒绝
        }else if(tbRiderList.get(0).getStatus()!=2){
            tbRider.setMsg("2");//已被其他管理员通过
            return tbRider;
        }else{
            tbRiderMapper.deleteRider(openId);
            tbRider.setMsg("1");//拒绝成功
            return tbRider;
        }
    }

    /**
     * 骑手上线下线状态改变
     * @param openId
     */
    @Override
    public void riderLineType(String openId,Integer status) {
        tbRiderMapper.updateStatus(openId, status);
    }

    /**
     * 根据appId获取相应的骑手列表
     * @param appId
     * @return
     */
    @Override
    public List<TbRider> selectAppId(String appId) {
        List<TbPoint> tbPointList=tbPointMapper.selectAppAll(appId,6);//获取已有骑手列表
        List<TbRider> tbRiderList=tbRiderMapper.selectOnlineRider(5);//获取上线骑手
        if(tbPointList.size()<=0){
            return tbRiderList;
        }
        for(int i=0;i<tbRiderList.size();i++){
            for(TbPoint tbPoint:tbPointList){
                if(tbPoint.getOpenId().equals(tbRiderList.get(i).getOpenId())){
                    tbRiderList.remove(i);
                    break;
                }
            }
        }
        return tbRiderList;
    }

    /**
     * 获取所有的骑手
     * @return
     */
    @Override
    public List<TbRider> selectAllRider(String sno,Integer start) {
        List<TbRider> tbRiderList=null;
        if(sno.equals("")){
            tbRiderList=tbRiderMapper.selectAllRider(new RowBounds((start-1)*10,10));
            if(tbRiderList.size()<=0){
                TbRider tbRider=new TbRider();
                tbRider.setMsg("0");
                tbRiderList.add(tbRider);
            }else{
                tbRiderList.get(0).setMsg(tbRiderMapper.selectAllRiderNumber().size()+"");
            }
            return tbRiderList;
        }else{
            tbRiderList=tbRiderMapper.selectAllSnoRider(sno,new RowBounds((start-1)*10,10));
            if(tbRiderList.size()<=0){
                TbRider tbRider=new TbRider();
                tbRider.setMsg("0");
                tbRiderList.add(tbRider);
            }else{
                tbRiderList.get(0).setMsg(tbRiderMapper.selectAllSnoRiderNumber(sno).size()+"");
            }
            return tbRiderList;
        }
    }

    /**
     * 删除骑手
     * @param openId
     * @return
     */
    @Override
    public TbRider deleteRider(String openId) {
        TbRider tbRider=new TbRider();
        if(tbPointMapper.deleteRider(openId).size()>=1){
            tbRider.setMsg("0");
            return tbRider;
        }else{
            tbRiderMapper.deleteRider(openId);
            tbRider.setMsg("1");
        }
        return tbRider;
    }
}
