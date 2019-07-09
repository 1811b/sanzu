package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShouHuo implements Serializable {
    private Integer  addressId;//  ----主键
    private String    addPeople;//  ----收货人
    private Integer    areaId;//   地区
    private String      juTiArea;//   --具体地址
    private String     phone;//       电话
    private Integer   userId;//  --关联用户表
}
