package com.everysucceed.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
//@ToString
public class TbGoods {
    private Long dataId;
    private String goodsName;
    private String goodsMerchant;
    private Float goodsPrice;
    private String goodsDesc;
    private Float teJia;
}
