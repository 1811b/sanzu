package com.jk.service;

import com.jk.model.LunBo;
import com.jk.model.TreeBean;
import com.jk.model.User;
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
    @GetMapping("selectTree")
    public List<TreeBean> selectTree() {
        return null;
    }

    @Override
    @GetMapping("selectLunZhan")
    public List<LunBo> selectLunZhan() {
        return null;
    }
}
