package com.jk.service;

import com.jk.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@RequestMapping("/error")
@Component
public class CkServiceError implements CkService{
    @Override
    public User text(User user) {
        return null;
    }

    @Override
    public HashMap<String, Object> selectUser() {
        return null;
    }
}
