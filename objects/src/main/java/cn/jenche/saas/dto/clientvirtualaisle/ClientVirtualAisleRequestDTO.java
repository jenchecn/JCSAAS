package cn.jenche.saas.dto.clientvirtualaisle;

import cn.jenche.saas.entity.ClientVirtualAisleEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/7/24 18:07
 * @Description:
 */
@Data
@ApiModel(value = "终端虚拟货道请求DTO")
public class ClientVirtualAisleRequestDTO extends ClientVirtualAisleEntity {
}
