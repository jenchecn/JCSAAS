/**
 *
 */
package cn.jenche.saas.service;

import cn.jenche.saas.entity.VirtualAisleConfigEntity;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 上午9:21:13
 * @Description: 虚拟货道配置接口
 */
public interface IVirtualAisleConfigService extends IBaseService<VirtualAisleConfigEntity> {
    /**
     * 获取list
     *
     * @return {@link List<VirtualAisleConfigEntity>}
     */
    List<VirtualAisleConfigEntity> LIST();
}

