package com.jk.controller;

import com.jk.model.Book;
import com.jk.model.BookImgs;
import com.jk.model.DianZiBook;
import com.jk.service.BookServiceapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookServiceapi bookService;

    //图书展示
    @RequestMapping("findBookList")
    @ResponseBody
    public HashMap<String, Object> findBookList(Integer page, Integer rows, @RequestBody Book book) {
        return bookService.findBookList(page, rows, book);
    }

    //删除图书
    @RequestMapping("delBook")
    @ResponseBody
    public Boolean delBook(Integer productId) {
        try {
            bookService.delBook(productId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //新增图书
    @RequestMapping("saveBook")
    @ResponseBody
    public void saveBook(@RequestBody Book book){
        bookService.saveBook(book);
    }


   //图书下架
    @RequestMapping("xiaJia")
    @ResponseBody
    public void xiaJia(Integer productId,Integer shangStatus) {
            bookService.xiaJia(productId,shangStatus);
    }

    //图书促销
    @RequestMapping("cuXiao")
    @ResponseBody
    public void cuXiao(Integer productId,Integer cuStatus) {
        bookService.cuXiao(productId,cuStatus);
    }
    //图书热卖
    @RequestMapping("remai")
    @ResponseBody
    public void remai(Integer productId,Integer reStatus) {
        bookService.remai(productId,reStatus);
    }

    //图书推荐
    @RequestMapping("tuijian")
    @ResponseBody
    public void tuijian(Integer productId,Integer tuiStatus) {
        bookService.tuijian(productId,tuiStatus);
    }





    //轮播图展示
    @RequestMapping("findList")
    @ResponseBody
    public HashMap<String, Object> findList(Integer page, Integer rows, @RequestBody BookImgs bookImgs) {
        return bookService.findList(page, rows, bookImgs);
    }



    //删除轮播图
    @RequestMapping("delImg")
    @ResponseBody
    public Boolean delImg(Integer imgId) {
        try {
            bookService.delImg(imgId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //新增轮播图
    @RequestMapping("saveImg")
    @ResponseBody
    public void saveImg(@RequestBody BookImgs bookImgs){
        bookService.saveImg(bookImgs);
    }





    //电子书展示
    @RequestMapping("queryBookList")
    @ResponseBody
    public HashMap<String, Object> queryBookList(Integer page, Integer rows, @RequestBody DianZiBook dianZiBook) {
        return bookService.queryBookList(page, rows, dianZiBook);
    }

    //删除电子书
    @RequestMapping("delQueryBook")
    @ResponseBody
    public Boolean delQueryBook(Integer productId) {
        try {
            bookService.delQueryBook(productId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //新增电子书
    @RequestMapping("saveQuery")
    @ResponseBody
    public void saveQuery(@RequestBody DianZiBook dianZiBook){
        bookService.saveQuery(dianZiBook);
    }

    //电子书上下架
    @RequestMapping("xia")
    @ResponseBody
    public void xia(Integer productId) {

        bookService.xia(productId);

    }

    @RequestMapping("shang")
    @ResponseBody
    public void shang(Integer productId) {

        bookService.shang(productId);

    }




}
