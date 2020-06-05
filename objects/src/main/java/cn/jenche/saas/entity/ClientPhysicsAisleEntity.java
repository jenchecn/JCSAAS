package cn.jenche.saas.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/6/3 11:57
 * @Description: 终端物理货道实体
 */
@Data
@Document(collection = "client_physics_aisle")
public class ClientPhysicsAisleEntity extends BaseEntity {
    @Field(value = "client_id")
    @ApiModelProperty("终端Id")
    private String ClientId;

    @Field(value = "aisle_number")
    @ApiModelProperty("货道号码")
    private int aisleNumber;

    @Field(value = "goods_id")
    @ApiModelProperty("商品Id")
    private String goodsId;

    /**
     * 折扣
     * <p>
     * 填写打折数字，以百分比表示。
     * eg: 10 = 10%
     * 100（正常） - 10（折扣） = 90（支付）
     * </p>
     */
    @ApiModelProperty("折扣")
    private int discount;

    /**
     * 库存
     */
    @ApiModelProperty("库存量")
    private int inventory;

    /**
     * 货道是否可用
     * <p>默认可用</p>
     */
    @ApiModelProperty("货道是否可用")
    private boolean status = true;
}
