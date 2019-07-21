package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserBean implements Serializable {
    private Integer  userId;
    private String   userName;
    private String   account;
    private String   password;
}
