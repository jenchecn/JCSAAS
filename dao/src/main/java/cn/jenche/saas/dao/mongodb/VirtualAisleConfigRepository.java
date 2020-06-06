/**
 * 
 */
package cn.jenche.saas.dao.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.jenche.saas.entity.VirtualAisleConfigEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 上午9:26:57
 * @Description: 虚拟货道
 */

public interface VirtualAisleConfigRepository extends MongoRepository<VirtualAisleConfigEntity, String> {
}

