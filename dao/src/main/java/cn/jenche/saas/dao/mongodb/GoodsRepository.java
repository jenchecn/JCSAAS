/**
 *
 */
package cn.jenche.saas.dao.mongodb;

import cn.jenche.saas.entity.GoodsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月3日 下午3:26:25
 * @Description: GoodsRepository
 */
public interface GoodsRepository extends MongoRepository<GoodsEntity, String> {
    /**
     * 根据分类Id判断数据是否存在
     *
     * @param categoryId 分类Id
     * @return {@link boolean}
     */
    boolean existsByCategoryId(String categoryId);
}
