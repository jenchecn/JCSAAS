package cn.jenche.saas.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/21 14:59
 * @Description:
 */
@Data
public class BaseEntity {
    @Id
    private String id;

    @Field(value = "create_date")
    private Date createDate = new Date();

    @Field(value = "modify_date")
    private Date modifyDate = new Date();
}
