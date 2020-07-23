package cn.jenche.saas.entity.location;

import cn.jenche.saas.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/30 11:20
 * @Description: 区/镇
 */
@Data
@Document(collection = "district")
@ApiModel(value = "区/镇")
public class DistrictEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名字", required = true)
    private String name;

    @ApiModelProperty(value = "代码", required = true)
    private String code;

    @ApiModelProperty(value = "所属父级", required = true)
    private String parentId;
}
