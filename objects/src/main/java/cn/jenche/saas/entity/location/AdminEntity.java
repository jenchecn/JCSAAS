
package cn.jenche.saas.entity.location;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.jenche.saas.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月1日 上午10:04:48
 * @Description: 管理员
 */
@Data
@Document(collection = "admin")
public class AdminEntity extends BaseEntity{
	@ApiModelProperty(value = "用户名", required = true)
	private String name;

	@ApiModelProperty(value = "密码", required = true)
	private String password;
	
}
