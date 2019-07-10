package com.jk.controller;

import com.jk.model.LunBo;
import com.jk.model.User;
import com.jk.service.CkServiceFeign;
import com.jk.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class CkController {

    @Autowired
    private CkServiceFeign feign;

    @RequestMapping("aaa")
    public User text(){
        User user = new User();
        user.setAccount("chenkai");
        user.setPassword("chenkaizuishuai");
        User user1 = feign.text(user);
        return user1;

    }


    @GetMapping("selectUser")
    public HashMap<String,Object>  selectUser(){
        return feign.selectUser();
    }

    /**
     * OSS阿里云上传图片
     */
    @PostMapping("updaloadImg")
    public String uploadImg(MultipartFile imgg) throws IOException {
        if (imgg == null || imgg.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(imgg);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        //System.out.println(split[0]);
        return split[0];
    }

    @PostMapping("addLunBoTu")
    public void addLunBoTu(LunBo lunBo){
        feign.addLunBoTu(lunBo);

    }


    @GetMapping("selectLunBo")
    public HashMap<String,Object>  selectLunBo(@RequestParam(value = "start") Integer start,
                                               @RequestParam(value = "pageSize") Integer pageSize){
        return feign.selectLunBo(start,pageSize);

    }
}
