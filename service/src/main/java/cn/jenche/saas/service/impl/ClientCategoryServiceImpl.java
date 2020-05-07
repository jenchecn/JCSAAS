package cn.jenche.saas.service.impl;

import cn.jenche.core.Pager;
import cn.jenche.saas.dao.mongodb.ClientCategoryRepository;
import cn.jenche.saas.entity.ClientCategoryEntity;
import cn.jenche.saas.service.IClientCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 14:05
 * @Description: 终端类型服务
 */

@Service
public class ClientCategoryServiceImpl implements IClientCategoryService<ClientCategoryEntity> {
    private final ClientCategoryRepository clientCategoryRepository;

    @Autowired
    public ClientCategoryServiceImpl(ClientCategoryRepository clientCategoryRepository) {
        this.clientCategoryRepository = clientCategoryRepository;
    }

    @Override
    public Pager<ClientCategoryEntity> LIST_PAGES(Pager<ClientCategoryEntity> pager) {
        Page<ClientCategoryEntity> data = clientCategoryRepository.findAll(pager.getPageable());
        return pager.convert(data);
    }

    @Override
    public ClientCategoryEntity SAVE(ClientCategoryEntity entity) {
        return clientCategoryRepository.save(entity);
    }

    @Override
    public ClientCategoryEntity UPDATE(ClientCategoryEntity entity) {
        return SAVE(entity);
    }
}
