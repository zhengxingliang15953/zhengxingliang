package com.example.demo.service.Impl;
import com.example.demo.entity.TbNotice;
import com.example.demo.mapper.TbNoticeMapper;
import com.example.demo.service.TbNoticeService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TbNoticeServiceImpl implements TbNoticeService {

    @Resource
    private TbNoticeMapper tbNoticeMapper;

    /**
     * 添加公告通知
     * @param title
     * @param message
     */
    @Override
    public void insertNotice(String title, String message,String noticeId) {

        tbNoticeMapper.insertNotice(title,message,noticeId);
    }

    /**
     * 删除公告通知
     * @param noticeId
     */
    @Override
    public void deleteNotice(String noticeId) {
        tbNoticeMapper.deleteNotice(noticeId);
    }

    /**
     * 获取所有公告
     * @return
     */
    @Override
    public List<TbNotice> selectAll(Integer start) {
        List<TbNotice> tbNoticeList=tbNoticeMapper.selectAll(new RowBounds((start-1)*10,10));
        tbNoticeList.get(0).setStatus(tbNoticeMapper.selectNumberNotice().size());
        return tbNoticeList;
    }

    /**
     * 修改公告
     * @param title
     * @param message
     * @param noticeId
     */
    @Override
    public void updateNotice(String title, String message, String noticeId) {
        tbNoticeMapper.updateNotice(title,message,noticeId);
    }
}
