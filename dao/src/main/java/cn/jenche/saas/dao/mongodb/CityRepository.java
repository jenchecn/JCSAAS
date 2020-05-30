package cn.jenche.saas.dao.mongodb;

import cn.jenche.saas.entity.location.CityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/30 11:25
 * @Description:
 */
public interface CityRepository extends MongoRepository<CityEntity, String> {
}