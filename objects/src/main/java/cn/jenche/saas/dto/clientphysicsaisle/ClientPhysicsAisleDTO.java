package cn.jenche.saas.dto.clientphysicsaisle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 上午11:29:16
 * @Description: 终端物理货道
 */
@Data
@ApiModel(value = "物理货道")
public class ClientPhysicsAisleDTO {
    @ApiModelProperty(value = "终端Id", required = true)
    @NotBlank
    private String clientId;

    @ApiModelProperty(value = "物理货道DTO扩展参数")
    List<ClientPhysicsAisleExtDTO> clientPhysicsAisleExtDTOS;
}
