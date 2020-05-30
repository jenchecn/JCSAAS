package cn.jenche.saas.dao.mongodb;

import cn.jenche.saas.entity.location.DistrictEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/30 11:26
 * @Description:
 */
public interface DistrictRepository extends MongoRepository<DistrictEntity, String> {
}
