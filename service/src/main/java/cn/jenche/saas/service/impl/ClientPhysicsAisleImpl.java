/**
 * 
 */
package cn.jenche.saas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ClientPhysicsAisleImpl extends BaseServiceImpl<ClientPhysicsAisleEntity>
		implements IClientPhysicsAisleService {
	@Autowired
	public ClientPhysicsAisleImpl(ClientPhysicsAisleRepository clientPhysicsAisleRepository) {
		super(clientPhysicsAisleRepository);
	}

	@Override
	public List<ClientPhysicsAisleEntity> LIST() {
		// TODO Auto-generated method stub
		return null;
	}
}
