package com.jk.service;

import com.jk.model.LunBo;
import com.jk.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

public interface CkService {
    @RequestMapping("aaa")
    User text(@RequestBody User user);

    @GetMapping("selectUser")
    HashMap<String, Object> selectUser();

    @PostMapping("addLunBoTu")
    void addLunBoTu(@RequestBody LunBo lunBo);

    @GetMapping("selectLunBo/{start}/{pageSize}")
    HashMap<String, Object> selectLunBo(@PathVariable(value = "start") Integer start,
                                        @PathVariable(value = "pageSize") Integer pageSize);
}
