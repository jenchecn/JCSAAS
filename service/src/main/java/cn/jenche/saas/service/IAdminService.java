package cn.jenche.saas.service;

import java.util.List;

import cn.jenche.saas.entity.location.AdminEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Description: 管理员服务
 */
public interface IAdminService extends IBaseService<AdminEntity> {
	/**
	 * 获取list
	 *
	 * @return {@link List<AdminEntity>}
	 */
	List<AdminEntity> LIST();
}
