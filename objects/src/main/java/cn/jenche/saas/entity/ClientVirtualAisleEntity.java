package cn.jenche.saas.entity;

import cn.jenche.saas.BaseEntity;
import cn.jenche.saas.dto.clientvirtualaisle.ClientVirtualAisleExtDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/6/5 14:28
 * @Description: 终端虚拟货道实体
 */
@Data
@Document(collection = "client_virtual_aisle")
public class ClientVirtualAisleEntity extends BaseEntity {
    @Field(value = "client_id")
    @ApiModelProperty("终端Id")
    private String clientId;

    @Field(value = "virtual_aisle_config_id")
    @ApiModelProperty("虚拟货道配置Id")
    private String virtualAisleConfigId;
    /**
     * 虚拟货道商品售价
     */
    @Field(value = "sell_price")
    @ApiModelProperty("虚拟货道商品售价")
    private double sellPrice;

    /**
     * 物理货道Id列表
     */
    @Field(value = "physics_aisle_id_list")
    @ApiModelProperty("物理货道列表")
    private List<ClientVirtualAisleExtDTO> physicsAisleIdList;
}
