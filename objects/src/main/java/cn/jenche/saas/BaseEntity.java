package cn.jenche.saas;

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
 * @Description: 公共Entity
 * <p/>当不需要数据中存在保存数据时需要在字段上注解{@see @Transient}
 * <p/>或者将DTO重新复制到Entity中，保证数据的统一性
 */
@Data
public class BaseEntity implements Serializable {
    @Id
    @ApiModelProperty(value = "Id, 新建时不需要传此字段")
    private String id;

    @Field(value = "create_date")
    @ApiModelProperty(value = "创建时间，不传此参数自动生成当前系统时间")
    private Date createDate = new Date();

    @Field(value = "modify_date")
    @ApiModelProperty(value = "修改时间，不传此参数自动生成当前系统时间")
    private Date modifyDate = new Date();
}
