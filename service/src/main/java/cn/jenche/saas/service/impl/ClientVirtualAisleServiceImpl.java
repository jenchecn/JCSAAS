package cn.jenche.saas.service.impl;

import cn.jenche.saas.dao.mongodb.ClientVirtualAisleRepository;
import cn.jenche.saas.entity.ClientVirtualAisleEntity;
import cn.jenche.saas.service.IClientVirtualAisleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 下午2:37:37
 * @Description: 终端虚拟货道服务
 */
@Service
public class ClientVirtualAisleServiceImpl extends BaseServiceImpl<ClientVirtualAisleEntity>
        implements IClientVirtualAisleService {

    private final ClientVirtualAisleRepository clientVirtualAisleRepository;

    @Autowired
    public ClientVirtualAisleServiceImpl(MongoRepository<ClientVirtualAisleEntity, String> repository,
                                         ClientVirtualAisleRepository clientVirtualAisleRepository) {
        super(repository);
        this.clientVirtualAisleRepository = clientVirtualAisleRepository;

    }

    @Override
    public List<ClientVirtualAisleEntity> FIND_BY_CLIENTID(String clientId) {
        return clientVirtualAisleRepository.findAllByClientId(clientId);
    }

    @Override
    public boolean existsByClientId(String clientId) {
        return clientVirtualAisleRepository.existsByClientId(clientId);
    }
}
