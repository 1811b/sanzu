package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserXinXi implements Serializable {
    private Integer    xinId; //主键
    private Integer   userId;    //userId
    private String     nickName;    //昵称
    private Integer    sex;           // 性别---1、男2、女
    private String    img;           //头像
    private Integer   marriage;   // 婚姻状况--1、已婚2、未婚
    private String     idNumber;   //身份证号码
    private Integer   educStatus;  //教育程度1、小学、2、初中/3、4、中专5、高中/6、专科、7、本科/8、硕士研究生/9、博士研究生/10、博士后
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date birthday;    //生日
    private Integer    areaId;   //地区
    private String      juTiArea;   //具体地址
}
