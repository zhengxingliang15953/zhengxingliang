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
     * @param bookDate
     * @param author
     * @param press
     * @param bookName
     * @param bookNumber
     * @param bookUrl
     * @param address
     */
    @Override
    public TbBook insertBook(String isbn,String bookName,String author,String press,int bookDate,int bookNumber,String bookUrl,String address) {
        TbBook book=new TbBook();
        if(tbBookMapper.selectIsbnBook(isbn)==null){
            tbBookMapper.insertBook(isbn, bookName, author, press, bookDate, bookNumber,0,0, bookUrl, address);
            book.setMsg("添加成功");
        }else{
            book.setMsg("添加失败");
        }
        return book;
    }

    /**
     * 删除图书
     * @param isbn
     */
    @Override
    public void deleteBook(String isbn) {
        tbBookMapper.deleteBook(isbn);
    }

    /**
     * 修改图书
     * @param isbn
     * @param bookName
     * @param author
     * @param press
     * @param bookDate
     * @param bookNumber
     * @param bookUrl
     * @param address
     * @return
     */
    @Override
    public TbBook updateBook(String isbn, String bookName, String author, String press, int bookDate, int bookNumber, String bookUrl, String address) {
        TbBook book=new TbBook();
        if(tbBookMapper.selectIsbnBook(isbn)==null){
            book.setMsg("添加成功");
            tbBookMapper.updateBook(isbn, bookName, author, press, bookDate, bookNumber, bookUrl, address);
        }else{
            book.setMsg("添加失败");
        }
        return book;
    }

    /**
     * 根据书名查询(精确)
     * @param bookName
     * @return
     */
    @Override
    public List<TbBook> selectBookNameBook1(String bookName) {
        return tbBookMapper.selectBookNameBook1(bookName);
    }

    /**
     * 根据author查询
     * @param author
     * @return
     */
    @Override
    public List<TbBook> selectAuthorBook(String author) {
        return tbBookMapper.selectAuthorBook(author);
    }

    /**
     * 根据书名查询(模糊)
     * @param bookName
     * @return
     */
    @Override
    public List<TbBook> selectBookNameBook2(String bookName) {
        return tbBookMapper.selectBookNameBook2(bookName);
    }
}
