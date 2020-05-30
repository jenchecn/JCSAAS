package cn.jenche.saas.entity;

import cn.jenche.saas.entity.location.LocationCityEntity;
import cn.jenche.saas.entity.location.LocationDistrictEntity;
import cn.jenche.saas.entity.location.LocationProvinceEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/29 16:22
 * @Description:
 */
@Data
public class ConsignerLocationEntity {
    @ApiModelProperty(value = "省/直辖市", required = true)
    private LocationProvinceEntity province;
    @ApiModelProperty(value = "市/县", required = true)
    private LocationCityEntity city;
    @ApiModelProperty(value = "区/镇", required = true)
    private LocationDistrictEntity district;
}
