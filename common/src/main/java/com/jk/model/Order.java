package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order implements Serializable {
    private Integer  orderId;//  --主键
    private String    orderNo;//  --订单号
    private Integer   userId ;// --谁买的
    private String     commodityNo;//  --商品编号
    private String      proName ;//   --商品名称
    private Integer   orderStatus;//  --订单状态1、待评价2、已评价3、追加评价
    private BigDecimal    sumPrice;//  --总价格
    private String      userName;//    --收货人
    private String     areaName;//  --收货地址
    private String     expressName;//   --快递单号
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date       createTime;//   --下单时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private  Date      updateTime;//  --更新时间
    private String   payNo;//   --支付交易号--关联支付表
    private String   payText;//  --支付信息
    private Integer   proNumber ;// --商品数量
    private BigDecimal    orderPrice;//  --商品价格
}
