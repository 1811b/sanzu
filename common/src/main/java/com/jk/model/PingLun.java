package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class PingLun implements Serializable {
    private Integer   commentId;//  --评论ID
    private String     proNo;//  --商品编号
    private Integer  userId;//  --用户ID
    private String    comContext;//  --评论内容
    private String      imgs;//  --图片合集
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;//  --评论时间
    private Integer   count;//  --点赞数量
    private Integer    xingJi;//  --评论星级

    //临时字段
    private String      nickName;//用户昵称
}
