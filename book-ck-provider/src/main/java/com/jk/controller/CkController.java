package com.jk.controller;

import com.jk.model.User;
import com.jk.service.CkService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CkController implements CkService {

    @RequestMapping("aaa")
    @Override
    public User text(@RequestBody User user) {
        user.setUserId(111);
        user.setBirthday(new Date());
        return user;
    }
}
