package cn.jenche.saas.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/6/3 11:30
 * @Description: 商品分类
 */
@Data
@Document(collection = "goods_category")
public class GoodsCategoryEntity extends BaseEntity {

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 描述或者备注
     */
    @ApiModelProperty(value = "描述")
    private String desc;
}
