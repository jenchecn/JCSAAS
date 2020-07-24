package cn.jenche.saas.service;

import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.clientvirtualaisle.ClientVirtualAisleResponseDTO;
import cn.jenche.saas.entity.ClientVirtualAisleEntity;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 下午2:38:02
 * @Description: 终端虚拟货道服务
 */
public interface IClientVirtualAisleService extends IBaseService<ClientVirtualAisleEntity> {
    /**
     * 根据客户端Id获取终端虚拟列表
     *
     * @param clientId 终端Id
     * @return {@link List<ClientVirtualAisleEntity>} 列表
     */
    List<ClientVirtualAisleEntity> FIND_BY_CLIENTID(String clientId);

    /**
     * 根据终端Id获取物理货道是否存在
     *
     * @param clientId 终端Id
     * @return {@link Boolean}
     */
    boolean existsByClientId(String clientId);

    /**
     * 根据终端Id获取DTO数据
     *
     * @param clientId 终端Id
     * @return {@link List< ClientVirtualAisleResponseDTO >}
     */
    List<ClientVirtualAisleResponseDTO> GET_DTO_BY_CLIENTID(String clientId) throws SystemException;
}
