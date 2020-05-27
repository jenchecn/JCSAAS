package cn.jenche.saas.service.impl;

import cn.jenche.core.Pager;
import cn.jenche.saas.dao.mongodb.ClientRepository;
import cn.jenche.saas.entity.ClientEntity;
import cn.jenche.saas.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 17:46
 * @Description:
 */
@Service
public class ClientServiceImplImpl implements IClientService<ClientEntity> {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImplImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientEntity ONE_BYID(String id) {
        return null;
    }

    @Override
    public Pager<ClientEntity> LIST_PAGES(Pager<ClientEntity> pager) {
        Page<ClientEntity> data = clientRepository.findAll(pager.getPageable());
        return pager.convert(data);
    }

    @Override
    public ClientEntity SAVE(ClientEntity entity) {
        return clientRepository.save(entity);
    }

    @Override
    public ClientEntity UPDATE(ClientEntity entity) {
        return SAVE(entity);
    }

    @Override
    public void DELETE(String id) {
        clientRepository.deleteById(id);
    }
}
