
package cn.jenche.saas.dao.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.jenche.saas.entity.location.AdminEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月1日 下午8:05:02
 * @Description: 
 */
public interface AdminRepository extends MongoRepository<AdminEntity, String> {

}
