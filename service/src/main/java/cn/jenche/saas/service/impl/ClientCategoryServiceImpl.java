package cn.jenche.saas.service.impl;

import cn.jenche.saas.dao.mongodb.ClientCategoryRepository;
import cn.jenche.saas.entity.ClientCategoryEntity;
import cn.jenche.saas.service.IClientCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 14:05
 * @Description: 终端类型服务
 */

@Service
public class ClientCategoryServiceImpl extends BaseServiceImpl<ClientCategoryEntity> implements IClientCategoryService {
    @Autowired
    public ClientCategoryServiceImpl(ClientCategoryRepository clientCategoryRepository) {
        super(clientCategoryRepository);
    }
}
