/**
 * 
 */
package cn.jenche.saas.dao.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.jenche.saas.entity.GoodsEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月3日 下午3:26:25
 * @Description: GoodsRepository
 */
public interface GoodsRepository extends MongoRepository<GoodsEntity, String> {

}
