package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Author implements Serializable {
    private Integer    authorId;//   --作者ID
    private String       authorName;//  --作者
    private String       jianJie;//     --作者简介
}
