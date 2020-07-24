package cn.jenche.saas.dto;

import cn.jenche.saas.dto.clientphysicsaisle.ClientPhysicsAisleExtGoodsDTO;
import cn.jenche.saas.dto.clientvirtualaisle.ClientVirtualAisleDTO;
import cn.jenche.saas.entity.ClientEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月9日 上午11:37:17
 * @Description: 终端实体
 */
@Data
@ApiModel(value = "终端实体")
public class ClientDTO extends ClientEntity {
    private List<ClientVirtualAisleDTO> clientVirtualAisleDTOList;
    private List<ClientPhysicsAisleExtGoodsDTO> clientPhysicsAisleExtGoodsDTOList;
}
