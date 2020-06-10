package cn.jenche.saas.dao.mongodb;

import cn.jenche.saas.entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 15:46
 * @Description: ClientRepository
 */
public interface ClientRepository extends MongoRepository<ClientEntity, String> {

    /**
     * 根据终端代码获取Client
     *
     * @param code 终端代码
     * @return {@link ClientEntity}
     */
    ClientEntity findOneByCode(String code);

    /**
     * 根据分类Id获取终端是否存在
     *
     * @param categoryId 分类Id
     * @return {@link Boolean}
     */
    boolean existsByClientCategoryId(String categoryId);
}
