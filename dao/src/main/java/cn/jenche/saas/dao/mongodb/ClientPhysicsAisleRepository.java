package cn.jenche.saas.dao.mongodb;

import cn.jenche.saas.entity.ClientPhysicsAisleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 上午11:29:45
 * @Description: ClientPhysicsAisleRepository
 */
public interface ClientPhysicsAisleRepository extends MongoRepository<ClientPhysicsAisleEntity, String> {
    /**
     * 根据ClientId查找全部物理货道
     *
     * @param clientId 终端Id
     * @return {@link List<ClientPhysicsAisleEntity>} 列表数据
     */
    List<ClientPhysicsAisleEntity> findAllByClientIdOrderByAisleNumberAsc(String clientId);

    /**
     * 根据终端Id获取物理货道是否存在
     *
     * @param clientId 终端Id
     * @return {@link Boolean}
     */
    boolean existsByClientId(String clientId);
}
