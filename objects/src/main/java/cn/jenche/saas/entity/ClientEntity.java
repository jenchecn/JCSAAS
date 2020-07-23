package cn.jenche.saas.entity;

import cn.jenche.saas.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 17:23
 * @Description: 终端的实体数据
 */

@Data
@Document(collection = "client")
public class ClientEntity extends BaseEntity {
    /**
     * 终端机类别
     */
    @Field(value = "client_category_id")
    @ApiModelProperty(value = "终端分类Id", required = true)
    private String clientCategoryId;

    /**
     * 终端编码
     */
    @ApiModelProperty(value = "终端编码")
    private String code;


    /**
     * 机器编号
     */
    @ApiModelProperty(value = "机器编号", required = true, dataType = "int")
    private int number;

    /**
     * 终端的Imei码
     */
    @Field(value = "imei")
    @ApiModelProperty(value = "设备主板的串码信息", required = true)
    private String iMei;

    /**
     * 委托实体ID
     */
    @Field(value = "consigner_id")
    @ApiModelProperty(value = "委托实体ID", required = true)
    private String consignerId;

    /**
     * 启用虚拟货道
     * <p>默认关闭</p>
     */
    @Field(value = "enable_virtual_aisle")
    @ApiModelProperty(value = "启用虚拟货道，默认关闭")
    private boolean enableVirtualAisle = false;

    /**
     * 当前终端状态
     * <p>默认关闭</p>
     */
    @ApiModelProperty(value = "当前终端状态")
    private boolean status = false;
}
