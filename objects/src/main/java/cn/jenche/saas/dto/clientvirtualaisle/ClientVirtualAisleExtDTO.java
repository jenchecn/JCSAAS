package cn.jenche.saas.dto.clientvirtualaisle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/7/24 18:00
 * @Description:
 */
@Data
public class ClientVirtualAisleExtDTO {
    @Field(value = "priority")
    @ApiModelProperty("物理货道优先级")
    private int priority;

    @Field(value = "physics_aisle_id")
    @ApiModelProperty("物理货道Id")
    private String physicsAisleId;
}
