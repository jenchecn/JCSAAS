package cn.jenche.saas.service;

import cn.jenche.saas.entity.location.ProvinceEntity;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/30 11:27
 * @Description: 省/直辖市服务
 */
public interface IProvinceService extends IBaseService<ProvinceEntity> {
    /**
     * 获取list
     *
     * @return {@link List<ProvinceEntity>}
     */
    List<ProvinceEntity> LIST();
}
