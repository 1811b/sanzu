package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookImgs implements Serializable {
    private Integer   imgId;//  --主键
    private String     proNo;//  --商品编号
    private String     imgs;//   --图片地址
}
