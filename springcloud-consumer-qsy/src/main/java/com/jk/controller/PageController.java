package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {
    //书籍查询
    @RequestMapping("findBookList")
    public String findBookList() {
        return "booklist";
    }


    @RequestMapping("toAddBook")
    public String toAddBook() {
        return "addbook";
    }

    //书籍查询
    @RequestMapping("findList")
    public String findList() {
        return "imglist";
    }



    @RequestMapping("toAddImg")
    public String toAddImg() {
        return "addimg";
    }




    @RequestMapping("queryBookList")
    public String queryBookList() {
        return "querylist";
    }

    @RequestMapping("toBook")
    public String toBook() {
        return "addQuery";
    }
}
