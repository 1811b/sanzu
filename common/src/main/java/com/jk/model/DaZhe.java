package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DaZhe implements Serializable {
    private Integer    zheId ;// --主键
    private Integer     jiZhe ;//  --打几折
}
