/**
 * 
 */
package cn.jenche.saas.service;

import java.util.List;

import cn.jenche.saas.entity.ClientPhysicsAisleEntity;


/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 上午11:29:02
 * @Description: 终端物理货道实体
 */
public interface IClientPhysicsAisleService extends IBaseService<ClientPhysicsAisleEntity> {
	/**
	 * 获取list
	 *
	 * @return {@link List<ClientPhysicsAisleEntity>}
	 */
	List<ClientPhysicsAisleEntity> LIST();

	ClientPhysicsAisleEntity ONE_BYCODE(String code);
}
