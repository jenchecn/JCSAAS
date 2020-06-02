/**
 * 
 */
package cn.jenche.saas.service;

import java.util.List;

import cn.jenche.saas.entity.location.AdminEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月1日 下午3:59:22
 * @Description: 管理员服务
 */
public interface IAdminService extends IBaseService<AdminEntity> {
	/**
	 * 获取list
	 *
	 * @return {@link List<ProvinceEntity>}
	 */
	List<AdminEntity> LIST();
}
