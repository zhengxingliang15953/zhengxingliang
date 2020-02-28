package com.example.demo.controller;

import com.example.demo.entity.TbBook;
import com.example.demo.service.TbBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin
@RestController
public class TbBookController {
    @Resource
    private TbBookService tbBookService;

    /**
     * 获取所有的图书
     * @return
     */
    @RequestMapping(value = "api/getAllBook",method = RequestMethod.GET)
    public List<TbBook> selectAllBook(String isbn,Integer start){
        return tbBookService.selectAllBook(isbn, start);
    }

    /**
     * 根据isbn获取图书
     * @param isbn
     * @return
     */
    @RequestMapping(value = "api/getIsbnBook",method = RequestMethod.GET)
    public List<TbBook> selectIsbnBook(String isbn){
        return tbBookService.selectIsbnBook(isbn);
    }

    /**
     * 添加书籍
     * @param isbn
     * @param bookName
     * @param author
     * @param press
     * @param bookDate
     * @param bookNumber
     * @param bookUrl
     * @param address
     */
    @RequestMapping(value = "api/getAddBook",method = RequestMethod.POST)
    public TbBook insertBook(String isbn,String bookName,String author,String press,int bookDate,int bookNumber,String bookUrl,String address){
       return tbBookService.insertBook(isbn, bookName, author, press, bookDate, bookNumber, bookUrl, address);
    }

    /**
     * 删除图书
     * @param isbn
     */
    @RequestMapping(value = "api/getDeleteBook",method = RequestMethod.GET)
    public void deleteBook(String isbn){
        tbBookService.deleteBook(isbn);
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
    @RequestMapping(value = "api/getUpdateBook",method = RequestMethod.POST)
    public TbBook updateBook(String isbn, String bookName, String author, String press, int bookDate, int bookNumber, String bookUrl, String address) {
        return tbBookService.updateBook(isbn, bookName, author, press, bookDate, bookNumber, bookUrl, address);
    }

    /**
     * 根据bookName精确查询
     * @param bookName
     * @return
     */
    @RequestMapping(value = "api/getBookName1",method = RequestMethod.GET)
    public List<TbBook> selectBookName1(String bookName,Integer start){
        return tbBookService.selectBookNameBook1(bookName, start);
    }

    /**
     * 根据author查询
     * @param author
     * @return
     */
    @RequestMapping(value = "api/getAuthorBook",method = RequestMethod.GET)
    public List<TbBook> selectAuthor(String author,Integer start){
        return tbBookService.selectAuthorBook(author,start);
    }

    /**
     * 根据bookName查询（模糊）
     * @param bookName
     * @return
     */
    @RequestMapping(value = "api/getBookName2",method = RequestMethod.GET)
    public List<TbBook> selectBookName2(String bookName,Integer start){
        return tbBookService.selectBookNameBook2(bookName,start);
    }
}
