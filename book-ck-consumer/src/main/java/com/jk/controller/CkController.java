package com.jk.controller;

import com.jk.model.LunBo;
import com.jk.model.TreeBean;
import com.jk.model.User;
import com.jk.service.CkServiceFeign;
import com.jk.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    public HashMap<String, Object> uploadImg(MultipartFile imgg) throws IOException {

        if (imgg == null || imgg.getSize() <= 0) {



            throw new IOException("file不能为空");

        }

        OSSClientUtil ossClient = new OSSClientUtil();

        String name = ossClient.uploadImg2Oss(imgg);

        String imgUrl = ossClient.getImgUrl(name);

        //  String[] split = imgUrl.split("\\?");



        HashMap<String, Object> map = new HashMap<>();

        map.put("imngName", imgUrl);



        return  map;

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

    @PutMapping("updateLunBo")
    public void  updateLunBo(LunBo lunBo){
        feign.updateLunBo(lunBo);
    }

    @DeleteMapping("deleteLun")
    public void  deleteLun(@RequestParam(value = "id")Integer id){
        feign.deleteLun(id);
    }

    @PutMapping("updateStatus")
    public void  updateStatus(@RequestParam(value = "id")Integer id,
                              @RequestParam(value = "zt")Integer zt){
        feign.updateStatus(id,zt);
    }

    //查询树
    @GetMapping("selectTree")
    public List<TreeBean>  selectTree(){
       return feign.selectTree();
    }

}
