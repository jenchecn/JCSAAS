package cn.jenche.saas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import cn.jenche.saas.entity.location.DistrictEntity;

import cn.jenche.saas.service.IDistrictService;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020/5/30 11:29
 * @Description: 区/镇服务
 */
@Service
public class DistrictServicelImpl extends BaseServiceImpl<DistrictEntity> implements IDistrictService{
	@Autowired 
	public DistrictServicelImpl(MongoRepository<DistrictEntity, String> repository) {
		super(repository);
		
	}

   @Override
	    public List<DistrictEntity> LIST() {
	        return repository.findAll();
	    }
}
