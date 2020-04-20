package cn.jenche.jceisp.service.impl;

import cn.jenche.jceisp.dao.mongodb.ClientRepository;
import cn.jenche.jceisp.entity.ClientEntity;
import cn.jenche.jceisp.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 17:46
 * @Description:
 */
@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<ClientEntity> ClientList() {
        return clientRepository.findAll();
    }
}
