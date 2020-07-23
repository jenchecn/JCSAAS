/**
 *
 */
package cn.jenche.saas.dto.clientvirtualaisle;

import cn.jenche.saas.entity.ClientVirtualAisleEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 下午2:38:58
 * @Description:
 */
@Data
@ApiModel(value = "终端虚拟货道")
public class ClientVirtualAisleDTO extends ClientVirtualAisleEntity {
    /**
     * 虚拟货道名字
     */
    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "前台展示的图片")
    private String image;

    /**
     * 虚拟货道描述
     */
    @ApiModelProperty(value = "描述")
    private String desc;
}
