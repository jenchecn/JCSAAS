/**
 * 
 */
package cn.jenche.saas.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import cn.jenche.saas.dao.mongodb.ClientPhysicsAisleRepository;
import cn.jenche.saas.entity.ClientPhysicsAisleEntity;
import cn.jenche.saas.service.IClientPhysicsAisleService;


/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 上午11:28:43
 * @Description: 终端物理货道实体
 */
@Service
public class ClientPhysicsAisleImpl
		extends BaseServiceImpl<ClientPhysicsAisleEntity>
		implements IClientPhysicsAisleService {

	private final ClientPhysicsAisleRepository clientPhysicsAisleRepository;

	@Autowired
	public ClientPhysicsAisleImpl(MongoRepository<ClientPhysicsAisleEntity, String> repository,
			ClientPhysicsAisleRepository clientPhysicsAisleRepository) {
		super(repository);
		this.clientPhysicsAisleRepository = clientPhysicsAisleRepository;

	}

	@Override
	public ClientPhysicsAisleEntity ONE_BYCODE(String code) {
		return clientPhysicsAisleRepository.findOneByCode(code);
	}

	@Override
	public List<ClientPhysicsAisleEntity> LIST() {
		// TODO Auto-generated method stub
		return null;
	}

}

