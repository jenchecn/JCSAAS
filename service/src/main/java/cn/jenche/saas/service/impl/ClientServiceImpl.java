package cn.jenche.saas.service.impl;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import cn.jenche.saas.dao.mongodb.ClientRepository;
import cn.jenche.saas.entity.ClientEntity;
import cn.jenche.saas.service.IClientService;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 17:46
 * @Description:终端实体
 */
@Service
public class ClientServiceImpl extends BaseServiceImpl<ClientEntity> implements IClientService {
	private final ClientRepository clientRepository;

	public ClientServiceImpl(MongoRepository<ClientEntity, String> repository, ClientRepository clientRepository) {
		super(repository);
		this.clientRepository = clientRepository;

	}

	@Override
	public ClientEntity ONE_BYCODE(String code) {
		return clientRepository.findOneByCode(code);
	}

}

