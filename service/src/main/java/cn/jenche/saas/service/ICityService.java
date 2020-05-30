package cn.jenche.saas.service;
import cn.jenche.saas.entity.location.CityEntity;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020/5/30 11:27
 * @Description:市\区服务
 */
public interface ICityService extends IBaseService<CityEntity>{
	/**
     * 获取list
     *
     * @return {@link List<CityEntity>}
     */
    List<CityEntity> LIST();
}
