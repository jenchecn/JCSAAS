package cn.jenche.saas.service.impl;

import cn.jenche.saas.dao.mongodb.DistrictRepository;
import cn.jenche.saas.entity.location.DistrictEntity;
import cn.jenche.saas.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020/5/30 11:29
 * @Description: 区/镇服务
 */
@Service
public class DistrictServicelImpl extends BaseServiceImpl<DistrictEntity> implements IDistrictService {
    private final DistrictRepository districtRepository;

    @Autowired
    public DistrictServicelImpl(MongoRepository<DistrictEntity, String> repository, DistrictRepository districtRepository) {
        super(repository);
        this.districtRepository = districtRepository;
    }

    @Override
    public List<DistrictEntity> LIST() {
        return repository.findAll();
    }

    @Override
    public List<DistrictEntity> LIST_BYPARENTID(String parentId) {
        return districtRepository.findAllByParentId(parentId);
    }
}
