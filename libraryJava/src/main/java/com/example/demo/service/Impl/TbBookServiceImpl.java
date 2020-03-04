package com.example.demo.service.Impl;

import com.example.demo.entity.TbBook;
import com.example.demo.mapper.TbAppointmentMapper;
import com.example.demo.mapper.TbBookMapper;
import com.example.demo.mapper.TbWaitMapper;
import com.example.demo.service.TbBookService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbBookServiceImpl implements TbBookService {

    @Resource
    private TbBookMapper tbBookMapper;

    @Resource
    private TbAppointmentMapper tbAppointmentMapper;

    @Resource
    private TbWaitMapper tbWaitMapper;

    /**
     * 获取所有的图书
     * @return
     */
    @Override
    public List<TbBook> selectAllBook(String isbn,Integer start) {
        List<TbBook> tbBookList=null;
        if(isbn.equals("")){
            tbBookList=tbBookMapper.selectAllBook(new RowBounds((start-1)*10,10));
            tbBookList.get(0).setStatus(tbBookMapper.selectAllJiShu().size());
        }else{
            tbBookList=tbBookMapper.selectIsbnBook(isbn);
            tbBookList.get(0).setStatus(1);
        }
        return tbBookList;
    }

    /**
     * 根据isbn获取book
     * @param isbn
     * @return
     */
    @Override
    public List<TbBook> selectIsbnBook(String isbn) {
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
        if(tbBookMapper.selectIsbnBook(isbn).size()==0){
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
    public TbBook deleteBook(String isbn) {
        TbBook tbBook=new TbBook();
        if(tbWaitMapper.selectIsbnWait(isbn).size()>=1){
            tbBook.setStatus(0);
            return tbBook;
        }else if(tbAppointmentMapper.deleteBookShow(isbn).size()>=1){
            tbBook.setStatus(0);
            return tbBook;
        }else{
            tbBookMapper.deleteBook(isbn);
            tbBook.setStatus(1);
            return tbBook;
        }
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
        if(tbBookMapper.selectIsbnBook(isbn).size()>=1){
            book.setMsg("修改成功");
            tbBookMapper.updateBook(isbn, bookName, author, press, bookDate, bookNumber, bookUrl, address);
        }else{
            book.setMsg("修改失败");
        }
        return book;
    }

    /**
     * 根据书名查询(精确)
     * @param bookName
     * @return
     */
    @Override
    public List<TbBook> selectBookNameBook1(String bookName,Integer start) {
        List<TbBook> tbBookList=tbBookMapper.selectBookNameBook1(bookName,new RowBounds((start-1)*10,10));
        if(tbBookList.size()<=0){

            return tbBookList;
        }
        tbBookList.get(0).setStatus(tbBookMapper.selectBook1Number(bookName).size());
        return tbBookList;
    }

    /**
     * 根据author查询
     * @param author
     * @return
     */
    @Override
    public List<TbBook> selectAuthorBook(String author,Integer start) {
        List<TbBook> tbBookList=tbBookMapper.selectAuthorBook(author,new RowBounds((start-1)*10,10));
        if(tbBookList.size()<=0){

            return tbBookList;
        }
        tbBookList.get(0).setStatus(tbBookMapper.selectAuthorNumber(author).size());
        return tbBookList;
    }

    /**
     * 根据书名查询(模糊)
     * @param bookName
     * @return
     */
    @Override
    public List<TbBook> selectBookNameBook2(String bookName,Integer start) {
        List<TbBook> tbBookList=tbBookMapper.selectBookNameBook2(bookName,new RowBounds((start-1)*10,10));
        if(tbBookList.size()<=0){
            return tbBookList;
        }
        tbBookList.get(0).setStatus(tbBookMapper.selectBook2Number(bookName).size());
        return tbBookList;
    }

    /**
     * 图书上架、下架
     * @param isbn
     * @param type
     */
    @Override
    public void updateBookType(String isbn, Integer type) {
        if(type==0){
            tbBookMapper.updateBookType(isbn, 1);
        }else{
            tbBookMapper.updateBookType(isbn,0);
        }
    }
}
