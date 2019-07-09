package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DianZiContent implements Serializable {
    private Integer    contentId;//  --主键
    private String     proNumber;//  --商品编号
    private String     section ;// --章节名称
    private String    bookContent;//  --章节内容
}
