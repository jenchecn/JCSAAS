/**
 * 
 */
package cn.jenche.saas.service;

import cn.jenche.saas.entity.ClientVirtualAisleEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 下午2:38:02
 * @Description: 终端虚拟货道服务
 */
public interface IClientVirtualAisleService extends IBaseService<ClientVirtualAisleEntity> {

	ClientVirtualAisleEntity ONE_BYCODE(String code);

}
