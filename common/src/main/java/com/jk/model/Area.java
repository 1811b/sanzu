package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Area implements Serializable {
    private Integer   areaId;//  --主键
    private String     areaName;//  --名字
    private Integer   pid;//     --父ID
}
