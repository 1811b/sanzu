package com.jk.controller;

import com.jk.model.Book;
import com.jk.model.BookImgs;
import com.jk.model.DianZiBook;
import com.jk.service.BookServiceapi;
import com.jk.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@Controller
public class BookController {

    @Autowired
    private BookServiceapi bookService;

    //图书查询
    @RequestMapping("findBookList")
    @ResponseBody
    public HashMap<String,Object> findBookList (Integer page, Integer rows, Book book){
        return bookService.findBookList(page, rows, book);
    }

    //删除图书
    @RequestMapping("delBook")
    @ResponseBody
    public Boolean delBook(Integer productId){
        return bookService.delBook(productId);
    }


    //新增
    @RequestMapping("saveBook")
    @ResponseBody
    public void saveBook(Book book){
        bookService.saveBook(book);
    }

    /**
     * OSS阿里云上传图片
     */
    @RequestMapping("updaloadImg")
    @ResponseBody
    public HashMap<String, Object> uploadImg(MultipartFile imgg) throws IOException {
        if (imgg == null || imgg.getSize() <= 0) {

            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient = new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(imgg);
        String imgUrl = ossClient.getImgUrl(name);
        //String[] split = imgUrl.split("\\?");
        HashMap<String, Object> map = new HashMap<>();
        map.put("imngName", imgUrl);
        return  map;
    }


    //图书上下架
    @RequestMapping("xiaJia")
    @ResponseBody
    public void xiaJia(Integer productId,Integer shangStatus){
        bookService.xiaJia(productId,shangStatus);
    }

    //图书促销
    @RequestMapping("cuXiao")
    @ResponseBody
    public void cuXiao(Integer productId,Integer cuStatus){
        bookService.cuXiao(productId,cuStatus);
    }

    //图书热卖
    @RequestMapping("remai")
    @ResponseBody
    public void remai(Integer productId,Integer reStatus){
        bookService.remai(productId,reStatus);
    }

    //图书推荐
    @RequestMapping("tuijian")
    @ResponseBody
    public void tuijian(Integer productId,Integer tuiStatus){
        bookService.tuijian(productId,tuiStatus);
    }






    //轮播图查询
    @RequestMapping("findList")
    @ResponseBody
    public HashMap<String, Object> findList(Integer page, Integer rows,BookImgs bookImgs){
        return bookService.findList(page,rows,bookImgs);
    }


    //删除轮播图
    @RequestMapping("delImg")
    @ResponseBody
    public Boolean delImg(Integer imgId){
        return bookService.delImg(imgId);
    }

    //新增
    @RequestMapping("saveImg")
    @ResponseBody
    public void saveImg(BookImgs bookImgs){
        bookService.saveImg(bookImgs);
    }




    //电子书查询
    @RequestMapping("queryBookList")
    @ResponseBody
    public HashMap<String,Object> queryBookList (Integer page, Integer rows, DianZiBook dianZiBook){
        return bookService.queryBookList(page, rows, dianZiBook);
    }

    //删除电子书
    @RequestMapping("delQueryBook")
    @ResponseBody
    public Boolean delQueryBook(Integer productId){
       return bookService.delQueryBook(productId);
}

    //新增电子书
    @RequestMapping("saveQuery")
    @ResponseBody
    public void saveQuery(DianZiBook dianZiBook){
        bookService.saveQuery(dianZiBook);
    }

    //电子书上下架
    @RequestMapping("xia")
    @ResponseBody
    public void xia(Integer productId){
        bookService.xia(productId);
    }

    @RequestMapping("shang")
    @ResponseBody
    public void shang(Integer productId){
        bookService.shang(productId);
    }


}
