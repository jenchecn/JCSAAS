/**
 * 
 */
package cn.jenche.saas.dto;

import cn.jenche.saas.entity.location.AdminEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月1日 下午7:58:02
 * @Description: 管理员
 */
@Data
@ApiModel(value = "管理员")
public class AdminDTO extends AdminEntity {

}
