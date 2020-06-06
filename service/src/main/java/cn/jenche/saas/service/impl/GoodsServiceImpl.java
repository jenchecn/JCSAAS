package cn.jenche.saas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import cn.jenche.saas.entity.GoodsEntity;
import cn.jenche.saas.service.IGoodsService;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020/5/30 11:29
 * @Description:商品服务
 */
@Service
public class GoodsServiceImpl extends BaseServiceImpl<GoodsEntity> implements IGoodsService {
    @Autowired
    public GoodsServiceImpl(MongoRepository<GoodsEntity, String> repository) {
        super(repository);
    }

    @Override
    public List<GoodsEntity> LIST() {
        return repository.findAll();
    }
}
