package com.jk.service;

import com.jk.model.Book;
import com.jk.model.BookImgs;
import com.jk.model.DianZiBook;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

public interface BookServiceapi {
    //图书展示
    @RequestMapping("findBookList")
    public HashMap<String, Object> findBookList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestBody Book book);

    //删除图书
    @RequestMapping("delBook")
    public Boolean delBook(@RequestParam("productId") Integer productId);

    //新增图书
    @RequestMapping("saveBook")
    public void saveBook(@RequestBody Book book);



    //图书上下架
    @RequestMapping("xiaJia")
    public void xiaJia(@RequestParam("productId")Integer productId,@RequestParam("shangStatus")Integer shangStatus);


    //图书促销
    @RequestMapping("cuXiao")
    void cuXiao(@RequestParam("productId")Integer productId,@RequestParam("cuStatus")Integer cuStatus);


    //图书展示
    @RequestMapping("findList")
    public HashMap<String, Object> findList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows, @RequestBody BookImgs bookImgs);



    //删除轮播图
    @RequestMapping("delImg")
    public Boolean delImg(@RequestParam("imgId") Integer imgId);


    //新增图书
    @RequestMapping("saveImg")
    public void saveImg(@RequestBody BookImgs bookImgs);

    //查询电子书
    @RequestMapping("queryBookList")
    HashMap<String, Object> queryBookList(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows, @RequestBody DianZiBook dianZiBook);

    //删除电子束
    @RequestMapping("delQueryBook")
    public Boolean delQueryBook(@RequestParam("productId")Integer productId);

    //新增电子书
    @RequestMapping("saveQuery")
    void saveQuery(@RequestBody DianZiBook dianZiBook);


    @RequestMapping("xia")
    void xia(@RequestParam("productId")Integer productId);


    @RequestMapping("shang")
    void shang(@RequestParam("productId")Integer productId);

    @RequestMapping("remai")
    void remai(@RequestParam("productId")Integer productId, @RequestParam("reStatus") Integer reStatus);

    @RequestMapping("tuijian")
    void tuijian(@RequestParam("productId")Integer productId, @RequestParam("tuiStatus")Integer tuiStatus);
}