package cn.jenche.saas.dao.mongodb;

import cn.jenche.saas.entity.location.CityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/30 11:25
 * @Description: city Repository
 */
public interface CityRepository extends MongoRepository<CityEntity, String> {
    /**
     * by Parent the id Find all Data.
     *
     * @param parentId parent Id.
     * @return Generics Data {@link List<>}
     */
    List<CityEntity> findAllByParentId(String parentId);
}
