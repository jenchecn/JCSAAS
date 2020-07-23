package cn.jenche.saas.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/6/10 17:04
 * @Description:
 */
@Data
@ApiModel(value = "终端分类类型DTO")
public class ClientCategoryTypeDTO {
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "代码")
    private String code;
    @ApiModelProperty(value = "描述")
    private String desc;
}
