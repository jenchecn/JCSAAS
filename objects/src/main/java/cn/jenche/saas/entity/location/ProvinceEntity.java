package cn.jenche.saas.entity.location;

import cn.jenche.saas.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/30 11:06
 * @Description: 省或者直辖市
 */
@Data
@Document(collection = "province")
public class ProvinceEntity extends BaseEntity {
    @ApiModelProperty(value = "名字", required = true)
    private String name;

    @ApiModelProperty(value = "代码", required = true)
    private String code;
}
