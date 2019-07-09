package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer   userId;  //     id--主键
    private String     account;//      账号
    private String     password;//    密码
    private String     phone;//       电话
}
