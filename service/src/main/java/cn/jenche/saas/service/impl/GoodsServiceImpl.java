package cn.jenche.saas.service.impl;

import cn.jenche.saas.dao.mongodb.GoodsRepository;
import cn.jenche.saas.entity.GoodsEntity;
import cn.jenche.saas.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020/5/30 11:29
 * @Description:商品服务
 */
@Service
public class GoodsServiceImpl extends BaseServiceImpl<GoodsEntity> implements IGoodsService {
    private final GoodsRepository goodsRepository;

    @Autowired
    public GoodsServiceImpl(MongoRepository<GoodsEntity, String> repository, GoodsRepository goodsRepository) {
        super(repository);
        this.goodsRepository = goodsRepository;
    }

    @Override
    public List<GoodsEntity> LIST() {
        return repository.findAll();
    }

    @Override
    public boolean existsByCategoryId(String categoryId) {
        return goodsRepository.existsByCategoryId(categoryId);
    }
}
