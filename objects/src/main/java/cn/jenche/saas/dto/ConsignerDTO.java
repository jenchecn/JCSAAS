package cn.jenche.saas.dto;

import cn.jenche.saas.entity.ConsignerEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/28 09:54
 * @Description: 委托管理DTO
 */
@Data
@ApiModel(value = "委托管理DTO")
public class ConsignerDTO extends ConsignerEntity {
}
