package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderXiang implements Serializable {
    private Integer  detailId;//  --主键
    private Integer  orderId;//  --关联订单表
    private String    productNo;//  --商品编号
    private Integer   proNumber;//  --商品数量
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;//   --下单时间
    private BigDecimal orderPrice;//  --商品价格
}
