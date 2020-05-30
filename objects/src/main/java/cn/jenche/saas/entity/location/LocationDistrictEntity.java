package cn.jenche.saas.entity.location;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/29 16:27
 * @Description:
 */
@Data
public class LocationDistrictEntity {
    @ApiModelProperty(value = "区名字", required = true)
    @NotBlank(message = "区名字必须填写")
    private String name;

    @ApiModelProperty(value = "区Id", required = true)
    @NotBlank(message = "区Id必须填写")
    private String id;
}
