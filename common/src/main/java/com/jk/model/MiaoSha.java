package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class MiaoSha implements Serializable {
    private Integer    seckId;//  --秒杀商品表  id
    private String    proNo;//    --商品编号
    private Integer    seckCount;//  --库存
    private BigDecimal yuanPrice;//  --商品价格原价
    private BigDecimal   seckPrice;//  --商品价格秒杀价
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date startTime;//  --开始秒杀时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private  Date    endTime;//结束时间
}
