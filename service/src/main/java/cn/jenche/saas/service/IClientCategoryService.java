package cn.jenche.saas.service;

import cn.jenche.saas.entity.ClientCategoryEntity;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 14:02
 * @Description: 终端类型
 */
public interface IClientCategoryService extends IBaseService<ClientCategoryEntity> {

    /**
     * 在实体列表中查找满足Id数据
     *
     * @param entities 实体列表
     * @param id       id
     * @return 返回满足的一条数据 {@link ClientCategoryEntity}
     */
    ClientCategoryEntity findByIdWithEntitys(List<ClientCategoryEntity> entities, String id);
}
