package cn.jenche.saas.service;

import java.util.List;

import cn.jenche.saas.entity.GoodsEntity;

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
}