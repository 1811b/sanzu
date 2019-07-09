package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DianZiXiang implements Serializable {
    private Integer   xqId;//  --主键
    private String     proNumber;//  --商品编号
    private Integer     yuZhong;//   --语种  1-中文  2-英文
    private Integer     ziShu ;// --字数
    private String       fileSize;//  --文件大小
    private String        fileGeShi;//   --文件格式
    private  String         jcszContext;//  --精彩书摘
}
