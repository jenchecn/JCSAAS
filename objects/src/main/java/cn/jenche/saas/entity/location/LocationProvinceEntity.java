package cn.jenche.saas.entity.location;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/29 16:23
 * @Description: 省
 */
@Data
public class LocationProvinceEntity {
    @ApiModelProperty(value = "省份名字", required = true)
    @NotBlank(message = "省份名字必须填写")
    private String name;


    @ApiModelProperty(value = "省份Id", required = true)
    @NotBlank(message = "省份Id必须填写")
    private String id;
}
