package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShouCang implements Serializable {
    private Integer    collectId;//   --主键
    private String     proNumber;//  --商品编号
    private Integer     userId ;//  --用户ID
}
