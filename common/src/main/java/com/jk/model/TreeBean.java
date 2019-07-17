package com.jk.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class TreeBean implements Serializable {

    private static final long serialVersionUID = 6977158765924832482L;
    private Integer id;
    private String text;
    private Integer pid;
    private String url;
    private List<TreeBean> nodes;
    private Boolean selectable;//节点是否可以被选中


}
