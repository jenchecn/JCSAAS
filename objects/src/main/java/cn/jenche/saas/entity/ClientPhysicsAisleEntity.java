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
    @Field(value = "aisle_number")
    @ApiModelProperty("货道号码")
    private int aisleNumber;


    private String goodsId;
}
