package cn.jenche.saas.entity;

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
    private String clientCategoryId;

    /**
     * 终端编码
     */
    private String code;

    /**
     * 终端的Imei码
     */
    @Field(value = "imei")
    private String iMei;

    /**
     * 终端所在的地址 例如：北京市朝阳区朝阳门外大街乙12号东门
     */
    private String address;

    /**
     * 终端所在位置，使用经纬度表示位置123.999,23.999
     */
    private String location;

    /**
     * 当前终端状态
     */
    private boolean status;
}
