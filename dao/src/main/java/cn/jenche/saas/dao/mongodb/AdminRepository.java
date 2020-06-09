package cn.jenche.saas.dao.mongodb;

import cn.jenche.saas.entity.location.AdminEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月1日 下午8:05:02
 * @Description:
 */
public interface AdminRepository extends MongoRepository<AdminEntity, String> {
    /**
     * 根据名字判断是否存在
     *
     * @param name 管理员名称
     * @return {@link Boolean}
     */
    boolean existsByName(String name);
}
