package com.jk.service;

import com.jk.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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
    @PutMapping("updateLunBo")
    void updateLunBo(@RequestBody LunBo lunBo);

    @RequestMapping("selectLunById/{id}")
    LunBo selectLunById(@PathVariable(value = "id") Integer id);

    @DeleteMapping("deleteLun/{id}")
    void deleteLun(@PathVariable(value = "id") Integer id);

    @PutMapping("updateStatus/{id}/{zt}")
    void updateStatus(@PathVariable(value = "id") Integer id,
                      @PathVariable(value = "zt") Integer zt);

    @GetMapping("selectTree/{pid}")
    List<TreeBean> selectTree(@PathVariable(value = "pid") Integer pid);

    @GetMapping("selectLunZhan")
    List<LunBo> selectLunZhan();

    @GetMapping("selectBookZheng")
    List<Book> selectBookZheng();

    @RequestMapping("login")
    UserBean login(@RequestBody UserBean userBean);
}
