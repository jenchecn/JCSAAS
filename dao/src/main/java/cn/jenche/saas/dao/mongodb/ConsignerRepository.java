package cn.jenche.saas.dao.mongodb;

import cn.jenche.saas.entity.ConsignerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/28 09:23
 * @Description: 委托场地相关Dao
 */
public interface ConsignerRepository extends MongoRepository<ConsignerEntity, String> {
}
