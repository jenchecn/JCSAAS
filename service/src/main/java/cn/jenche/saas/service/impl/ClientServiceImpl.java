package cn.jenche.saas.service.impl;

import cn.jenche.core.ExceptionMessage;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dao.mongodb.ClientRepository;
import cn.jenche.saas.entity.ClientEntity;
import cn.jenche.saas.service.IClientPhysicsAisleService;
import cn.jenche.saas.service.IClientService;
import cn.jenche.saas.service.IClientVirtualAisleService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 17:46
 * @Description:终端实体
 */
@Service
public class ClientServiceImpl extends BaseServiceImpl<ClientEntity> implements IClientService {
    private final IClientPhysicsAisleService clientPhysicsAisleService;
    private final IClientVirtualAisleService clientVirtualAisleService;
    private final ClientRepository clientRepository;

    public ClientServiceImpl(MongoRepository<ClientEntity, String> repository, IClientPhysicsAisleService clientPhysicsAisleService, IClientVirtualAisleService clientVirtualAisleService, ClientRepository clientRepository) {
        super(repository);
        this.clientPhysicsAisleService = clientPhysicsAisleService;
        this.clientVirtualAisleService = clientVirtualAisleService;
        this.clientRepository = clientRepository;

    }

    @Override
    public ClientEntity ONE_BYCODE(String code) {
        return clientRepository.findOneByCode(code);
    }

    @Override
    public boolean existsByCategoryId(String categoryId) {
        return clientRepository.existsByClientCategoryId(categoryId);
    }

    @Override
    public void DELETE(Serializable... ids) throws SystemException {
        if (ids != null && ids.length > 0) {
            for (Serializable id : ids) {
                String _id = String.valueOf(id);
                //处理物理货道
                if (clientPhysicsAisleService.existsByClientId(_id)) {
                    throw new SystemException(ExceptionMessage.S_20_DELETE_EXISTS_PART);
                }

                //处理虚拟货道
                if (clientVirtualAisleService.existsByClientId(_id)) {
                    throw new SystemException(ExceptionMessage.S_20_DELETE_EXISTS_PART);
                }

                if (repository.existsById(_id)) {
                    repository.deleteById(_id);
                }
            }
            return;
        }

        throw new SystemException(ExceptionMessage.S_20_DELETE_ERROR);
    }
}

