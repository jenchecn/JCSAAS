package cn.jenche.saas.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/6/3 11:31
 * @Description: 商品
 */
@Data
@Document(collection = "goods")
public class GoodsEntity extends BaseEntity {

    /**
     * 分类Id
     */
    @Field(value = "category_id")
    @ApiModelProperty(value = "分类Id")
    private String categoryId;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    @Field(value = "cover_image")
    @ApiModelProperty(value = "商品封面")
    private String CoverImage;

    /**
     * 商品进价
     */
    @Field(value = "buy_price")
    private double buyPrice;

    /**
     * 销售给顾客的价格
     */
    @Field(value = "sell_price")
    private double sellPrice;
}
