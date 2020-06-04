package cn.jenche.saas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import cn.jenche.saas.entity.GoodsCategoryEntity;
import cn.jenche.saas.service.IGoodsCategoryService;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月3日 下午5:19:57
 * @Description: 商品分类服务
 */
@Service
public class GoodsCategoryServiceImpl extends BaseServiceImpl<GoodsCategoryEntity> implements IGoodsCategoryService {
	@Autowired
	public GoodsCategoryServiceImpl(MongoRepository<GoodsCategoryEntity, String> repository) {
		super(repository);
	}

	@Override
	public List<GoodsCategoryEntity> LIST() {
		return repository.findAll();
	}
}