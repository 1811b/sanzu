package com.jk.service;

import com.jk.model.LunBo;
import com.jk.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/error")
@Component
public class CkServiceError implements CkService{
    @Override
    public User text(User user) {
        return null;
    }

    @GetMapping("selectUser")
    @Override
    public HashMap<String, Object> selectUser() {
        return null;
    }

    @Override
    @PostMapping("addLunBoTu")
    public void addLunBoTu(@RequestBody LunBo lunBo) {

    }

    @Override
    @GetMapping("selectLunBo")
    public HashMap<String, Object> selectLunBo(@PathVariable(value = "start") Integer start,
                                               @PathVariable(value = "pageSize") Integer pageSize) {
        return null;
    }
}
