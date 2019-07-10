package com.jk.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class XiLie implements Serializable {
    private Integer   genreId;//  --主键
    private String    productId;//   --商品编号
    private String    genreName;//   --类型
    private BigDecimal orderPrice;//  --商品价格
    private BigDecimal   zhePrice;//  --折后价格
    private Integer       zheId;//      --打折ID
    private Integer     proCount;//   --每个系列的库存（sku）
}
