package com.example.demo.controller;

import com.example.demo.entity.TbBook;
import com.example.demo.service.TbBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "图书管理api")
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
    @ApiOperation(value = "获取所有图书", notes = "获取所有图书",httpMethod = "GET")
    @RequestMapping(value = "api/getAllBook",method = RequestMethod.GET)
    public List<TbBook> selectAllBook(String isbn,Integer start){
        return tbBookService.selectAllBook(isbn, start);
    }

    /**
     * 根据isbn获取图书
     * @param isbn
     * @return
     */
    @ApiOperation(value = "根据isbn获取图书", notes = "根据isbn获取图书",httpMethod = "GET")
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
    @ApiOperation(value = "添加图书", notes = "添加图书",httpMethod = "POST")
    @RequestMapping(value = "api/getAddBook",method = RequestMethod.POST)
    public TbBook insertBook(String isbn,String bookName,String author,String press,int bookDate,int bookNumber,String bookUrl,String address){
       return tbBookService.insertBook(isbn, bookName, author, press, bookDate, bookNumber, bookUrl, address);
    }

    /**
     * 删除图书
     * @param isbn
     */
    @ApiOperation(value = "删除图书", notes = "删除图书",httpMethod = "GET")
    @RequestMapping(value = "api/getDeleteBook",method = RequestMethod.GET)
    public TbBook deleteBook(String isbn){
        return tbBookService.deleteBook(isbn);
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
    @ApiOperation(value = "修改图书", notes = "修改图书",httpMethod = "POST")
    @RequestMapping(value = "api/getUpdateBook",method = RequestMethod.POST)
    public TbBook updateBook(String isbn, String bookName, String author, String press, int bookDate, int bookNumber, String bookUrl, String address) {
        return tbBookService.updateBook(isbn, bookName, author, press, bookDate, bookNumber, bookUrl, address);
    }

    /**
     * 根据bookName精确查询
     * @param bookName
     * @return
     */
    @ApiOperation(value = "根据bookName精确查询", notes = "根据bookName精确查询",httpMethod = "GET")
    @RequestMapping(value = "api/getBookName1",method = RequestMethod.GET)
    public List<TbBook> selectBookName1(String bookName,Integer start){
        return tbBookService.selectBookNameBook1(bookName, start);
    }

    /**
     * 根据author查询
     * @param author
     * @return
     */
    @ApiOperation(value = "根据author查询", notes = "根据author查询",httpMethod = "GET")
    @RequestMapping(value = "api/getAuthorBook",method = RequestMethod.GET)
    public List<TbBook> selectAuthor(String author,Integer start){
        return tbBookService.selectAuthorBook(author,start);
    }

    /**
     * 根据bookName查询（模糊）
     * @param bookName
     * @return
     */
    @ApiOperation(value = "根据bookName模糊查询", notes = "根据bookName模糊查询",httpMethod = "GET")
    @RequestMapping(value = "api/getBookName2",method = RequestMethod.GET)
    public List<TbBook> selectBookName2(String bookName,Integer start){
        return tbBookService.selectBookNameBook2(bookName,start);
    }

    /**
     * 图书的上架下架
     * @param isbn
     * @param type
     */
    @ApiOperation(value = "图书上架下架", notes = "图书的上架下架",httpMethod = "GET")
    @RequestMapping(value = "api/getUpdateBookType",method = RequestMethod.GET)
    public void updateBookType(String isbn,Integer type){
        tbBookService.updateBookType(isbn, type);
    }
}
