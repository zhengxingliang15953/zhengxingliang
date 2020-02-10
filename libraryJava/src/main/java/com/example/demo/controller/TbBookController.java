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
    public List<TbBook> selectAllBook(){
        return tbBookService.selectAllBook();
    }

    /**
     * 根据isbn获取图书
     * @param isbn
     * @return
     */
    @RequestMapping(value = "api/getIsbnBook",method = RequestMethod.GET)
    public TbBook selectIsbnBook(String isbn){
        return tbBookService.selectIsbnBook(isbn);
    }

    /**
     * 添加书籍
     * @param isbn
     * @param name
     * @param author
     * @param press
     * @param date
     * @param number
     * @param bookUrl
     * @param address
     */
    @RequestMapping(value = "api/getAddBook",method = RequestMethod.POST)
    public TbBook insertBook(String isbn,String name,String author,String press,String date,Integer number,String bookUrl,String address){
       return tbBookService.insertBook(isbn, name, author, press, date, number, bookUrl, address);
    }
}
