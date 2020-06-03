/**
 *
 */
package cn.jenche.saas.service;

import cn.jenche.saas.entity.location.DistrictEntity;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年5月30日 下午4:45:58
 * @Description: 区/镇服务
 */
public interface IDistrictService extends IBaseService<DistrictEntity> {
    /**
     * 获取list
     *
     * @return {@link List<DistrictEntity>}
     */
    List<DistrictEntity> LIST();

    /**
     * 根据父类Id返回所拥有的县镇
     *
     * @param parentId 父类Id
     * @return {@link List}
     */
    List<DistrictEntity> LIST_BYPARENTID(String parentId);
}
