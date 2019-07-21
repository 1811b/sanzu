package com.jk.controller;

import com.jk.model.LunBo;
import com.jk.service.CkServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    @Autowired
    private CkServiceFeign feign;

    @RequestMapping("toAddLunBoTu")
    @CrossOrigin
    public String toAddLunBoTu(){
        return "lunBo/addDialog";
    }

    @RequestMapping("toLunBoTu")
    @CrossOrigin
    public String toLunBoTu(){
        return "lunBo/show";
    }

    @RequestMapping("toLun")
    @CrossOrigin
    public String toLun(){
        return "lunBo/lunBoTu";
    }

    @RequestMapping("toIndex")
    @CrossOrigin
    public String toIndex(){
        return "book/index";
    }

    @RequestMapping("toTree")
    @CrossOrigin
    public String toTree(){
        return "tree/tree";
    }

    @RequestMapping("toBook1")
    @CrossOrigin
    public String toBook1(){
        return "book/book-1";
    }

    @RequestMapping("toBook0")
    @CrossOrigin
    public String toBook0(){
        return "book/book-0";
    }


    @RequestMapping("toLunShouYe")
    @CrossOrigin
    public String toLunShouYe(){
        return "lunBo/shouye";
    }

    @CrossOrigin
    @RequestMapping("loginDialog")
    public  String  loginDialog(){

        return "login/loginDialog";

    }

    @CrossOrigin
    @RequestMapping("loginIndex")
    public  String  loginIndex(){

        return "login/index";

    }

    @RequestMapping("toBookShow")
    @CrossOrigin
    public String toBookShow(HttpServletRequest request){
        request.getSession().setAttribute("name","陈凯");
        System.out.println(request.getSession().getAttribute("name"));
        return "book/show";
    }

    @RequestMapping("toShouYe")
    @CrossOrigin
    public String toShouYe(){
        return "book/shouye";
    }


    @RequestMapping("selectLunById")
    @CrossOrigin
    public String selectLunById(@RequestParam(value = "id")Integer id, Model model){
        LunBo lunBo = feign.selectLunById(id);
        model.addAttribute("lun",lunBo);
        return "lunBo/updateDialog";
    }
}
