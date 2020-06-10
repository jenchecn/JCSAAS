package cn.jenche.saas.service.impl;

import cn.jenche.core.ExceptionMessage;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dao.mongodb.ClientCategoryRepository;
import cn.jenche.saas.entity.ClientCategoryEntity;
import cn.jenche.saas.service.IClientCategoryService;
import cn.jenche.saas.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 14:05
 * @Description: 终端类型服务
 */

@Service
public class ClientCategoryServiceImpl extends BaseServiceImpl<ClientCategoryEntity> implements IClientCategoryService {
    private final IClientService clientService;

    @Autowired
    public ClientCategoryServiceImpl(ClientCategoryRepository clientCategoryRepository, IClientService clientService) {
        super(clientCategoryRepository);
        this.clientService = clientService;
    }

    @Override
    public void DELETE(Serializable... ids) throws SystemException {
        if (ids != null && ids.length > 0) {
            for (Serializable id : ids) {
                String _id = String.valueOf(id);
                if (clientService.existsByCategoryId(_id)) {
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
