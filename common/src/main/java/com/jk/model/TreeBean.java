package com.jk.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class TreeBean implements Serializable {

    private Integer  tid;
    private String  text;
    private Integer  pid;
    private String  url;
    private List  nodes;


}
