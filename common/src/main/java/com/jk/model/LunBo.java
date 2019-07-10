package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LunBo implements Serializable {
    private Integer    imgId;//  --主键
    private String      imgName;//  --名称
    private String     imgUrl;//  --图片地址
    private String     clickUrl;//    --点击链接地址
    private Integer     imgStatus;//  --状态   1-展示  2-不展示
}
