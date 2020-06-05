package cn.jenche.saas.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/6/5 15:00
 * @Description: 虚拟货道配置信息
 */
@Data
@Document(collection = "virtual_aisle_config")
public class VirtualAisleConfigEntity extends BaseEntity {

    /**
     * 虚拟货道名字
     */
    @ApiModelProperty(value = "名字")
    private String name;

    /**
     * 图片
     */
    @Field(value = "image")
    @ApiModelProperty(value = "图片")
    private String image;

    /**
     * 虚拟货道描述
     */
    @ApiModelProperty(value = "描述")
    private String desc;
}
