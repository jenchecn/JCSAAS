package cn.jenche.saas.dto;

import cn.jenche.saas.entity.ClientCategoryEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 13:11
 * @Description: 终端分类
 */

@Data
@ApiModel(value = "终端类别")
public class ClientCategoryDTO extends ClientCategoryEntity {
}
