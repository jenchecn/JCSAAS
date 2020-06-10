/**
 *
 */
package cn.jenche.saas.dao.mongodb;

import cn.jenche.saas.entity.ClientVirtualAisleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 下午2:38:27
 * @Description: ClientVirtualAisleRepository
 */
public interface ClientVirtualAisleRepository extends MongoRepository<ClientVirtualAisleEntity, String> {
    /**
     * 根据客户端Id获取终端虚拟列表
     * @param clientId 终端Id
     * @return {@link List<ClientVirtualAisleEntity>} 列表
     */
    List<ClientVirtualAisleEntity> findAllByClientId(String clientId);

    /**
     * 根据终端Id获取虚拟货道是否存在
     *
     * @param clientId 终端Id
     * @return {@link Boolean}
     */
    boolean existsByClientId(String clientId);
}
