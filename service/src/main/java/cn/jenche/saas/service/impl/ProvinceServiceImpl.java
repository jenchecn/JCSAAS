package cn.jenche.saas.service.impl;

import cn.jenche.saas.entity.location.ProvinceEntity;
import cn.jenche.saas.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/30 11:29
 * @Description: 省/直辖市服务
 */
@Service
public class ProvinceServiceImpl extends BaseServiceImpl<ProvinceEntity> implements IProvinceService {
    @Autowired
    public ProvinceServiceImpl(MongoRepository<ProvinceEntity, String> repository) {
        super(repository);
    }

    @Override
    public List<ProvinceEntity> LIST() {
        return repository.findAll();
    }
}
