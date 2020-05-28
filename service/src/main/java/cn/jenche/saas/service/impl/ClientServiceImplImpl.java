package cn.jenche.saas.service.impl;

import cn.jenche.core.ExceptionMessage;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dao.mongodb.ClientRepository;
import cn.jenche.saas.entity.ClientEntity;
import cn.jenche.saas.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 17:46
 * @Description:
 */
@Service
public class ClientServiceImplImpl extends BaseServiceImpl<ClientEntity> implements IClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImplImpl(ClientRepository clientRepository) {
        super(clientRepository);
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientEntity UPDATE(ClientEntity entity) throws SystemException {
        if (clientRepository.existsById(entity.getId())) {
            return SAVE(entity);
        }
        throw new SystemException(ExceptionMessage.S_20_DATA_NOTEXISTS);
    }
}
