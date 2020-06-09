package cn.jenche.saas.entity;

import cn.jenche.saas.type.AdminRule;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月1日 上午10:04:48
 * @Description: 管理员
 */
@Data
@Document(collection = "admin")

public class AdminEntity extends BaseEntity {
    @ApiModelProperty(value = "用户名", required = true)
    private String name;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    /**
     * 管理员角色
     */
    @ApiModelProperty(value = "角色", required = true)
    private AdminRule rule;

}
