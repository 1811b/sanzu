package com.jk.controller;

import com.jk.redis.RedisKey;
import com.jk.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SeckillController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SeckillService seckillService;

    @GetMapping(value = "seckill_list")
    @ResponseBody
    public String findseckill(HttpServletRequest request, ModelMap modelMap){
        String seckill= (String) redisTemplate.opsForValue().get(RedisKey.SECKILL_LIST);
        if (!StringUtils.isEmpty(seckill)){
            return seckill;
        }


        return "page/seckill";
    }

}
