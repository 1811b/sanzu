package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class BookXiang implements Serializable {
    private Integer  introId;//  --主键
    private String    proNumber;//  ---商品编号
    private Integer    chuBanSheId;//    --出版社
    private Integer    authorId;//   --作者ID
    private Integer      language;//   --正文语种
    private Integer     yeCount;//  --页数
    private Integer     banCi;//  --版次
    private Integer    sixteenmo;//  --开本（纸张大小）1-16  2-32  3-64
    private Integer     taoCount;//  --套装数量
    private Integer     ziNumber;//   ---字数
    private Integer     ceCount;//  --共几册
    private String       jieShaoImg;//   --介绍图片
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;//  --创建时间
}
