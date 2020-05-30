
package cn.jenche.saas.dto;

import cn.jenche.saas.entity.location.CityEntity;
import cn.jenche.saas.entity.location.ProvinceEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年5月30日 下午3:10:58
 * @Description: 
 */
@Data
@ApiModel(value = "市/县")
public class CityDTO extends CityEntity{

}
