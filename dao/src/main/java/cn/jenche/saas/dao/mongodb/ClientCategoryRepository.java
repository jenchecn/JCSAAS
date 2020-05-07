package cn.jenche.saas.dao.mongodb;

import cn.jenche.saas.entity.ClientCategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 14:06
 * @Description: Client Category Repository Handle
 */
public interface ClientCategoryRepository extends MongoRepository<ClientCategoryEntity, String> {

}
