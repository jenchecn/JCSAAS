package cn.jenche.saas.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/27 17:05
 * @Description: 委托管理相关实体，终端设备所放的位置信息以及委托管理、位置等等相关信息
 */
@Data
@Document(collection = "consigner")
public class ConsignerEntity extends BaseEntity {
    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称必须填写")
    private String name;

    @ApiModelProperty(value = "行政区域位置", required = true)
    private ConsignerLocationEntity location;

    @ApiModelProperty(value = "地址", required = true)
    @NotBlank(message = "地址必须填写")
    private String address;

    @ApiModelProperty(value = "位置坐标，以经纬度显示，eg：10.123456,20,123456", required = true)
    @NotBlank(message = "坐标必须填写")
    private String position;

    @ApiModelProperty(value = "联系人", required = true)
    @NotBlank(message = "联系人必须填写")
    private String contact;

    @ApiModelProperty(value = "电话", required = true)
    @NotBlank(message = "电话必须填写")
    private String phone;

    @ApiModelProperty(value = "微信关联ID", required = true)
    @Field(value = "wechat_id")
    private String wechatId;

    @ApiModelProperty(value = "场地费用", required = true)
    private double expense;

    @ApiModelProperty(value = "佣金比例，占销售额的百分比", required = true)
    @Field(value = "commission_ratio")
    private int commissionRatio;
}
