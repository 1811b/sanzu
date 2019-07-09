package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class GouWu implements Serializable {
    private Integer  carId;//  --主键
    private Integer  genreId;//  --系列表ID
    private Integer  userId;//  --用户ID
    private Integer   proNumber;//  --商品数量
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;//   --创建时间
    private BigDecimal orderPrice;//  --商品价格
    private BigDecimal   sumPrice;//  --总价格
}
