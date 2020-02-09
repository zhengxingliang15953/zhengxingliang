package com.example.demo.service.Impl;

import com.example.demo.entity.TbBook;
import com.example.demo.mapper.TbBookMapper;
import com.example.demo.service.TbBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbBookServiceImpl implements TbBookService {

    @Resource
    private TbBookMapper tbBookMapper;

    /**
     * 获取所有的图书
     * @return
     */
    @Override
    public List<TbBook> selectAllBook() {
        return tbBookMapper.selectAllBook();
    }

    /**
     * 根据isbn获取book
     * @param isbn
     * @return
     */
    @Override
    public TbBook selectIsbnBook(String isbn) {
        return tbBookMapper.selectIsbnBook(isbn);
    }
}
