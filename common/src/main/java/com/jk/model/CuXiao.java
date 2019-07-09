package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CuXiao implements Serializable {
    private Integer   cuXiaoId;//   --主键
    private Integer    manPrice;//  --满多少钱才可以使用
    private Integer     jianPrice;//   --减的价格
}
