package com.jk.service;

import com.jk.dao.BookDao;
import com.jk.model.Book;
import com.jk.model.BookImgs;
import com.jk.model.DianZiBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookServiceapi{

    @Autowired
    private BookDao bookDao;

    @Override
    public HashMap<String, Object> findBookList(Integer page, Integer rows, Book book) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = bookDao.findBookTotal(book);
        //分页
        int start = (page-1)*rows;
        List<Book> list = bookDao.findBookPage(start,rows,book);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    public Boolean delBook(Integer productId) {

        return bookDao.delBook(productId);
    }

    @Override
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }


    @Override
    public void xiaJia(Integer productId,Integer shangStatus) {
        if (shangStatus==1){
             bookDao.xiaJia(productId, shangStatus);
        }else if(shangStatus==2){
            bookDao.shangJia(productId,shangStatus);
        }

    }

    @Override
    public void cuXiao(Integer productId, Integer cuStatus) {
        if (cuStatus==1){
            bookDao.cuXiao(productId, cuStatus);
        }else if(cuStatus==2){
            bookDao.buCu(productId,cuStatus);
        }
    }

    @Override
    public void remai(Integer productId, Integer reStatus) {
        if (reStatus==1){
            bookDao.remai(productId, reStatus);
        }else if(reStatus==2){
            bookDao.bure(productId,reStatus);
        }
    }

    @Override
    public void tuijian(Integer productId, Integer tuiStatus) {
        if (tuiStatus==1){
            bookDao.tuijian(productId, tuiStatus);
        }else if(tuiStatus==2){
            bookDao.butui(productId,tuiStatus);
        }
    }

    @Override
    public HashMap<String, Object> findList(Integer page, Integer rows, BookImgs bookImgs) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = bookDao.findTotal(bookImgs);
        //分页
        int start = (page-1)*rows;
        List<BookImgs> list = bookDao.findPage(start,rows,bookImgs);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    public Boolean delImg(Integer imgId) {

        return  bookDao.delImg(imgId);
    }

    @Override
    public void saveImg(BookImgs bookImgs) {
        bookDao.saveImg(bookImgs);
    }

    @Override
    public HashMap<String, Object> queryBookList(Integer page, Integer rows, DianZiBook dianZiBook) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = bookDao.queryTotal(dianZiBook);
        //分页
        int start = (page-1)*rows;
        List<DianZiBook> list = bookDao.queryPage(start,rows,dianZiBook);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    public Boolean delQueryBook(Integer productId) {

        return bookDao.delQueryBook(productId);
    }

    @Override
    public void saveQuery(DianZiBook dianZiBook) {
        bookDao.saveQuery(dianZiBook);
    }

    @Override
    public void xia(Integer productId) {
        bookDao.xia(productId);
    }

    @Override
    public void shang(Integer productId) {
        bookDao.shang(productId);
    }



}
