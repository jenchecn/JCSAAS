package cn.jenche.saas.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/27 17:05
 * @Description: 委托管理相关实体，终端设备所放的位置信息以及委托管理、位置等等相关信息
 */
@Data
@Document(collection = "consigner")
public class ConsignerEntity extends BaseEntity {
    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "位置坐标，以经纬度显示，eg：10.123456,20,123456")
    private String local;

    @ApiModelProperty(value = "联系人")
    private String contact;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "微信关联ID")
    @Field(value = "wechat_id")
    private String wechatId;

    @ApiModelProperty(value = "场地费用")
    private double expense;

    @ApiModelProperty(value = "佣金比例，占销售额的百分比")
    @Field(value = "commission_ratio")
    private int commissionRatio;
}
