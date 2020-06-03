package cn.jenche.saas.service.impl;

import cn.jenche.saas.dao.mongodb.CityRepository;
import cn.jenche.saas.entity.location.CityEntity;
import cn.jenche.saas.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/30 11:29
 * @Description: 市/县
 */
@Service
public class CityServiceImpl extends BaseServiceImpl<CityEntity> implements ICityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(MongoRepository<CityEntity, String> repository, CityRepository cityRepository) {
        super(repository);
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityEntity> LIST_BYPARENTID(String parentId) {
        return cityRepository.findAllByParentId(parentId);
    }
}
