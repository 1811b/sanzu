package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("toAddLunBoTu")
    public String toAddLunBoTu(){
        return "addDialog";
    }

    @RequestMapping("toLunBoTu")
    public String toLunBoTu(){
        return "show";
    }
}
