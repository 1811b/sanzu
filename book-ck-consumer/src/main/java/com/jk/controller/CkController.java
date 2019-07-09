package com.jk.controller;

import com.jk.model.User;
import com.jk.service.CkServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CkController {

    @Autowired
    private CkServiceFeign feign;

    @RequestMapping("aaa")
    public User text(){
        User user = new User();
        user.setAccount("chenkai");
        user.setPassword("chenkaizuishuai");
        User user1 = feign.text(user);
        return user1;

    }


    @GetMapping("selectUser")
    public HashMap<String,Object>  selectUser(){
        return feign.selectUser();
    }
}
