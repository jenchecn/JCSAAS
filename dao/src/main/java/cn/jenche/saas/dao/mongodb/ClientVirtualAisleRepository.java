/**
 * 
 */
package cn.jenche.saas.dao.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.jenche.saas.entity.ClientVirtualAisleEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 下午2:38:27
 * @Description: ClientVirtualAisleRepository
 */
public interface ClientVirtualAisleRepository extends MongoRepository<ClientVirtualAisleEntity, String> {

	ClientVirtualAisleEntity findOneByCode(String code);
}
