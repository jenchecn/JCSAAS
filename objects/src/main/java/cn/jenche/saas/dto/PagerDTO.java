package cn.jenche.saas.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/24 11:18
 * @Description:
 */
@Data
@ApiModel(value = "分页")
public class PagerDTO {
    /**
     * 页码
     */
    @ApiModelProperty(value = "页码")
    private int pageNo = 1;

    /**
     * 页面大小
     */
    @ApiModelProperty(value = "页面大小")
    private int pageSize = 20;
}
