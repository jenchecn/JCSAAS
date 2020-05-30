/**
 * 
 */
package cn.jenche.saas.service;

import java.util.List;

import cn.jenche.saas.entity.location.DistrictEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年5月30日 下午4:45:58
 * @Description:  区/镇服务
 */
public interface IDistrictService extends IBaseService<DistrictEntity>{
    /**
     * 获取list
     *
     * @return {@link List<DistrictEntity>}
     */
    List<DistrictEntity> LIST();
}
