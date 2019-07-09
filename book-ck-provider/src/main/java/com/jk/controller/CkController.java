package com.jk.controller;

import com.jk.mapper.CkMapper;
import com.jk.model.User;
import com.jk.service.CkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class CkController implements CkService {
    @Autowired
    private CkMapper  ckMapper;

    @RequestMapping("aaa")
    @Override
    public User text(@RequestBody User user) {
        user.setUserId(111);
        return user;
    }

    @Override
    @GetMapping("selectUser")
    public HashMap<String, Object> selectUser() {
        HashMap<String, Object> map = new HashMap<>();
        Integer sum = ckMapper.selectCount();
        map.put("total",sum);
        List<User>  list = ckMapper.selectUser();
        map.put("rows",list);
        return map;
    }
}
