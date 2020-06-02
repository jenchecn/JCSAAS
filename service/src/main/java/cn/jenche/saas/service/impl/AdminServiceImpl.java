/**
 * 
 */
package cn.jenche.saas.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import cn.jenche.saas.entity.location.AdminEntity;
import cn.jenche.saas.service.IAdminService;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月1日 下午3:58:29
 * @Description: 管理员服务
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<AdminEntity> implements IAdminService {
	@Autowired
	public AdminServiceImpl(MongoRepository<AdminEntity, String> repository) {
		super(repository);
	}

	@Override
	public List<AdminEntity> LIST() {
		return repository.findAll();
	}
}
