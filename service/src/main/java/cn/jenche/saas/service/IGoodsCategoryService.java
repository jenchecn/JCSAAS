package cn.jenche.saas.service;

import java.util.List;

import cn.jenche.saas.entity.GoodsCategoryEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月3日 下午5:21:48
 * @Description: 商品 分类
 */
public interface IGoodsCategoryService extends IBaseService<GoodsCategoryEntity> {
	/**
	 * 获取list
	 *
	 * @return {@link List<GoodsCategoryEntity>}
	 */
	List<GoodsCategoryEntity> LIST();
}




