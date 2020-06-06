
package cn.jenche.saas.dao.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.jenche.saas.entity.GoodsCategoryEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月3日 下午5:25:29
 * @Description: GoodsCategoryRepository
 */
public interface GoodsCategoryRepository extends MongoRepository<GoodsCategoryEntity, String> {

}


