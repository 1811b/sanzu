package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Type implements Serializable {
    private Integer   typeId;//   --主键
    private String    typeName;// --类型名称
    private String     url;//    --跳转页面的路径
    private Integer    pid;//  --父ID
}
