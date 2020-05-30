package cn.jenche.saas.entity.location;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/29 16:24
 * @Description: 市/县
 */
@Data
public class LocationCityEntity {
    @ApiModelProperty(value = "市/县", required = true)
    @NotBlank(message = "市/县名字必须填写")
    private String name;

    @ApiModelProperty(value = "市/县Id", required = true)
    @NotBlank(message = "市/县Id必须填写")
    private String id;
}
