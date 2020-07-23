package cn.jenche.saas.entity;

import cn.jenche.saas.BaseEntity;
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
     * 商品成本
     */
    @ApiModelProperty(value = "商品成本", example = "0.00")
    private double cost;

    /**
     * 原价
     */
    @ApiModelProperty(value = "商品原价", example = "0.00")
    private double orig;

    /**
     * 销售给顾客的价格
     */
    @ApiModelProperty(value = "商品售价", example = "0.00")
    private double price;
}
