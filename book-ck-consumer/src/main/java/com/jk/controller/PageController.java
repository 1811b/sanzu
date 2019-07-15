package com.jk.controller;

import com.jk.model.LunBo;
import com.jk.service.CkServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    @Autowired
    private CkServiceFeign feign;

    @RequestMapping("toAddLunBoTu")
    public String toAddLunBoTu(){
        return "addDialog";
    }

    @RequestMapping("toLunBoTu")
    public String toLunBoTu(){
        return "show";
    }

    @RequestMapping("toLun")
    public String toLun(){
        return "lunBoTu";
    }


    @RequestMapping("selectLunById")
    public String selectLunById(@RequestParam(value = "id")Integer id, Model model){
        LunBo lunBo = feign.selectLunById(id);
        model.addAttribute("lun",lunBo);
        return "updateDialog";
    }
}
