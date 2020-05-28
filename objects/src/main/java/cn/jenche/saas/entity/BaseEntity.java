package cn.jenche.saas.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/21 14:59
 * @Description:
 */
@Data
public class BaseEntity implements Serializable {
    @Id
    @ApiModelProperty(value = "id")
    private String id;

    @Field(value = "create_date")
    @ApiModelProperty(value = "创建时间，默认不传此参数自动生成当前系统时间")
    private Date createDate = new Date();

    @Field(value = "modify_date")
    @ApiModelProperty(value = "修改时间，默认不传此参数自动生成当前系统时间")
    private Date modifyDate = new Date();
}
