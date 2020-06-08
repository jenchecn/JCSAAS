/**
 * 
 */
package cn.jenche.saas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import cn.jenche.saas.entity.VirtualAisleConfigEntity;
import cn.jenche.saas.service.IVirtualAisleConfigService;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 上午9:17:56
 * @Description: 虚拟货道配置信服务
 */
@Service
public class VirtualAisleConfigServiceImpl extends BaseServiceImpl<VirtualAisleConfigEntity>
		implements IVirtualAisleConfigService {

	@Autowired
	VirtualAisleConfigServiceImpl(MongoRepository<VirtualAisleConfigEntity, String> repository) {
		super(repository);
	}

	@Override
	public List<VirtualAisleConfigEntity> LIST() {
		return repository.findAll();
	}
}