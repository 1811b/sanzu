package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {
    private Integer   productId;//  --主键
    private String     proNumber;//  --商品编号
    private Integer   typeId ;//   --类型表ID
    private String     proTitle;//  --书籍标题
    private String      proContext;//   --内容简介
    private String     shuPing ;//      --精彩书评
    private Integer    sumCount;//   --库存总数量(spu)
    private String     cover;//  --封面图
    private Integer   cuStatus;//  --是否促销1、是2、否
    private Integer   cuXiaoId;//  --促销ID（促销表）
    private Integer    reStatus;//  --是否热卖1、是2、否
    private Integer    shangStatus;//  --是否上架1、是2、否
    private Integer    tuiStatus;//  --是否推荐1、是2、否
}
