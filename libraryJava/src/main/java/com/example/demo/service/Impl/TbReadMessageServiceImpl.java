package com.example.demo.service.Impl;

import com.example.demo.entity.TbReadMessage;
import com.example.demo.mapper.TbReadMessageMapper;
import com.example.demo.service.TbReadMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbReadMessageServiceImpl implements TbReadMessageService {

    @Resource
    private TbReadMessageMapper tbReadMessageMapper;

    /**
     * 查询所有的读者留言
     * @return
     */
    @Override
    public List<TbReadMessage> selectAllReadMessage() {
        return tbReadMessageMapper.selectAllReadMessage();
    }

    /**
     * 添加读者留言
     * @param sno
     * @param message
     */
    @Override
    public void insertReadMessage(String sno, String message,String readId) {
        tbReadMessageMapper.insertReadMessage(sno,message,readId);
    }

    /**
     * 删除读者留言
     * @param readId
     */
    @Override
    public void deleteReadMessage(String readId) {
        tbReadMessageMapper.deleteReadMessage(readId);
    }

    /**
     * 根据搜索readMessage
     * @param sno
     * @return
     */
    @Override
    public List<TbReadMessage> selectOneReadMessage(String sno) {
        return tbReadMessageMapper.selectOneReadMessage(sno);
    }
}
