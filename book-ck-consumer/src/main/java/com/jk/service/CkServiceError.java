package com.jk.service;

import com.jk.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    @Override
    @PutMapping("updateLunBo")
    public void updateLunBo(@RequestBody LunBo lunBo) {

    }

    @Override
    @RequestMapping("selectLunById")
    public LunBo selectLunById(@PathVariable(value = "id") Integer id) {
        return null;
    }

    @Override
    @DeleteMapping("deleteLun")
    public void deleteLun(@PathVariable(value = "id") Integer id) {

    }

    @Override
    @PutMapping("updateStatus/{id}/{zt}")
    public void updateStatus(@PathVariable(value = "id") Integer id,
                             @PathVariable(value = "zt") Integer zt) {

    }

    @Override
    @RequestMapping("selectTree/{pid}")
    public List<TreeBean> selectTree(@PathVariable(value = "pid") Integer pid) {
        return null;
    }

    @Override
    @GetMapping("selectLunZhan")
    public List<LunBo> selectLunZhan() {
        return null;
    }

    @Override
    @GetMapping("selectBookZheng")
    public List<Book> selectBookZheng() {
        return null;
    }

    @RequestMapping("login")
    @Override
    public UserBean login(@RequestBody UserBean userBean) {
        return null;
    }
}
