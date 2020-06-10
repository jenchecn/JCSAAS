package cn.jenche.saas.dao.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.jenche.saas.entity.ClientEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 15:46
 * @Description: ClientRepository
 */
public interface ClientRepository extends MongoRepository<ClientEntity, String> {

	ClientEntity findOneByCode(String code);
}
