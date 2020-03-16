package com.example.demo.service.Impl;

import com.example.demo.entity.TbRider;
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
        if(tbRiderMapper.selectOpenId(openId).get(0).getStatus()<=0){
            tbRider.setMsg("1");
            tbRiderMapper.apply(openId, studentName, sno);
            return tbRider;
        }else{
            tbRider.setMsg("0");
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
}
