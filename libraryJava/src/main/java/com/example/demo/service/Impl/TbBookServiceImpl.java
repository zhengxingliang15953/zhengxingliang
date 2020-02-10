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

    /**
     * 添加图书
     * @param isbn
     * @param name
     * @param author
     * @param press
     * @param date
     * @param number
     * @param bookUrl
     * @param address
     */
    @Override
    public TbBook insertBook(String isbn, String name, String author, String press, String date, Integer number, String bookUrl, String address) {
        TbBook book=new TbBook();
        if(tbBookMapper.selectIsbnBook(isbn).getIsbn().equals(isbn)){
            tbBookMapper.insertBook(isbn, name, author, press, date, number, bookUrl, address);
            book.setMsg("添加成功");
        }else{
            book.setMsg("添加失败");
        }
        return book;
    }
}
