package com.jk.model;

import java.io.Serializable;
import java.util.List;

public class TreeBean implements Serializable {

    private static final long serialVersionUID = 6977158765924832482L;
    private Integer id;
    private String text;
    private Integer pid;
    private String href;
    private List<TreeBean> nodes;
    private Boolean selectable;//节点是否可以被选中

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<TreeBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeBean> nodes) {
        this.nodes = nodes;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }
}
