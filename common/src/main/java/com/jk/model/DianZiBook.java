package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class DianZiBook implements Serializable {
    private Integer   productId;//  --主键
    private String     proNumber;//  --商品编号
    private Integer   typeId ;//   --类型表ID
    private String typeName;//临时字段
    private String     proTitle;//  --书籍标题
    private String      proContext;//   --内容简介
    private BigDecimal bookPrice;//  --商品价格原价
    private String     cover;//  --封面图
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private  Date     shangTime;//  --上架时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;//  --出版时间
    private Integer    shangStatus;//  --是否上架1、是2、否


}
