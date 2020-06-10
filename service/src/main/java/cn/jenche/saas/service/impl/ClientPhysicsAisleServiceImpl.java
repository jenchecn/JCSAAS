package cn.jenche.saas.service.impl;


import cn.jenche.saas.dao.mongodb.ClientPhysicsAisleRepository;
import cn.jenche.saas.entity.ClientPhysicsAisleEntity;
import cn.jenche.saas.service.IClientPhysicsAisleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 上午11:28:43
 * @Description: 终端物理货道实体
 */
@Service
public class ClientPhysicsAisleServiceImpl
        extends BaseServiceImpl<ClientPhysicsAisleEntity>
        implements IClientPhysicsAisleService {

    private final ClientPhysicsAisleRepository clientPhysicsAisleRepository;

    @Autowired
    public ClientPhysicsAisleServiceImpl(MongoRepository<ClientPhysicsAisleEntity, String> repository,
                                         ClientPhysicsAisleRepository clientPhysicsAisleRepository) {
        super(repository);
        this.clientPhysicsAisleRepository = clientPhysicsAisleRepository;

    }

    @Override
    public List<ClientPhysicsAisleEntity> FIND_BY_CLIENTID(String clientId) {
        return clientPhysicsAisleRepository.findAllByClientIdOrderByAisleNumberAsc(clientId);
    }

    @Override
    public boolean existsByClientId(String clientId) {
        return clientPhysicsAisleRepository.existsByClientId(clientId);
    }

}

