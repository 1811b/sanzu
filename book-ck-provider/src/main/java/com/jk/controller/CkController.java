package com.jk.controller;

import com.jk.mapper.CkMapper;
import com.jk.model.LunBo;
import com.jk.model.User;
import com.jk.service.CkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Override
    @PostMapping("addLunBoTu")
    public void addLunBoTu(LunBo lunBo) {
        ckMapper.addLunBoTu(lunBo);
    }

    @Override
    @GetMapping("selectLunBo/{start}/{pageSize}")
    public HashMap<String, Object> selectLunBo(@PathVariable(value = "start") Integer start,
                                               @PathVariable(value = "pageSize") Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        Integer sum = ckMapper.selectLunBoCount();
        map.put("total",sum);
        List<LunBo>  list = ckMapper.selectLunBo(start,pageSize);
        map.put("rows",list);
        return map;
    }
}
