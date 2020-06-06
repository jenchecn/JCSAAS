/**
 * 
 */
package cn.jenche.saas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import cn.jenche.saas.entity.ClientVirtualAisleEntity;
import cn.jenche.saas.service.IClientVirtualAisleService;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 下午2:37:37
 * @Description: 终端虚拟货道服务
 */
@Service
public class ClientVirtualAisleImpl extends BaseServiceImpl<ClientVirtualAisleEntity>
		implements IClientVirtualAisleService {
	@Autowired
	public ClientVirtualAisleImpl(MongoRepository<ClientVirtualAisleEntity, String> repository) {
		super(repository);

	}

}
