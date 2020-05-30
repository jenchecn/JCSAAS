package cn.jenche.saas.dto;

import cn.jenche.saas.entity.location.ProvinceEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/30 11:57
 * @Description:
 */
@Data
@ApiModel(value = "区/镇")
public class ProvinceDTO extends ProvinceEntity {
}
