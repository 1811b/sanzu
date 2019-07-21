package com.jk.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;


@Data
@Document(indexName = "sanzu",type = "t_lunbotu")
public class LunBo implements Serializable {
    @Id
    @Field(type = FieldType.Integer,store = true)
    private Integer    imgId;//  --主键
    @Field(type = FieldType.Text,searchAnalyzer = "ik_max_word",store = true)
    private String      imgName;//  --名称
    @Field(type = FieldType.Text,store = true)
    private String     imgUrl;//  --图片地址
    @Field(type = FieldType.Text,store = true)
    private String     clickUrl;//    --点击链接地址
    @Field(type = FieldType.Integer,store = true)
    private Integer     imgStatus;//  --状态   1-展示  2-不展示
}
