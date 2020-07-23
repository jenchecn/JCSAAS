/**
 *
 */
package cn.jenche.saas.service;

import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.ClientPhysicsAisle.ClientPhysicsAisleDTO;
import cn.jenche.saas.entity.ClientPhysicsAisleEntity;

import java.util.List;


/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 上午11:29:02
 * @Description: 终端物理货道实体
 */
public interface IClientPhysicsAisleService extends IBaseService<ClientPhysicsAisleEntity> {
    /**
     * 根据终端Id获取当前终端的货道
     * @param clientId 终端Id
     * @return {@link List<ClientPhysicsAisleEntity>} 列表
     */
    List<ClientPhysicsAisleEntity> FIND_BY_CLIENTID(String clientId);

    /**
     * 根据终端Id获取物理货道是否存在
     *
     * @param clientId 终端Id
     * @return {@link Boolean}
     */
    boolean existsByClientId(String clientId);

    /**
     * 保存货道
     * @param clientPhysicsAisleDTO 终端物理货道DTO
     * @return {@link List<ClientPhysicsAisleEntity>}
     */
    List<ClientPhysicsAisleEntity> SAVE(ClientPhysicsAisleDTO clientPhysicsAisleDTO) throws SystemException;

    /**
     * 更新货道
     * @param clientPhysicsAisleDTO 终端物理货道DTO
     * @return {@link List<ClientPhysicsAisleEntity>}
     */
    List<ClientPhysicsAisleEntity> UPDATE(ClientPhysicsAisleDTO clientPhysicsAisleDTO) throws SystemException;
}
