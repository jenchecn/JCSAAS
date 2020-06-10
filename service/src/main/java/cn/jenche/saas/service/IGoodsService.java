package cn.jenche.saas.service;

import cn.jenche.saas.entity.GoodsEntity;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020/5/30 11:27
 * @Description: 商品服务
 */
public interface IGoodsService extends IBaseService<GoodsEntity> {
    /**
     * 获取list
     *
     * @return {@link List<GoodsEntity>}
     */
    List<GoodsEntity> LIST();

    /**
     * 根据分类Id判断数据是否存在
     *
     * @param categoryId 分类Id
     * @return {@link boolean}
     */
    boolean existsByCategoryId(String categoryId);
}
