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
    private Integer    imgId;//  --主键
    private String      imgName;//  --名称
    private String     imgUrl;//  --图片地址
    private String     clickUrl;//    --点击链接地址
    private Integer     imgStatus;//  --状态   1-展示  2-不展示
}
