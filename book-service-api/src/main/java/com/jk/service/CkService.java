package com.jk.service;

import com.jk.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

public interface CkService {
    @RequestMapping("aaa")
    User text(@RequestBody User user);

    @GetMapping("selectUser")
    HashMap<String, Object> selectUser();
}
