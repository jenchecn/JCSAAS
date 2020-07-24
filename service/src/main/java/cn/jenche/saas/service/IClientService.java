package cn.jenche.saas.service;

import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.ClientDTO;
import cn.jenche.saas.entity.ClientEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 17:44
 * @Description: 终端服务
 */
public interface IClientService extends IBaseService<ClientEntity> {

    /**
     * 根据Code获取终端数据
     *
     * @param code 终端代码
     * @return {@link ClientEntity}
     */
    ClientEntity ONE_BYCODE(String code);

    /**
     * 根据分类Id判断是否终端
     *
     * @param categoryId 分类Id
     * @return {@link boolean}
     */
    boolean existsByCategoryId(String categoryId);

    /**
     * 根据Client Code获取详细信息
     *
     * @param code Client Code
     * @return {@link ClientDTO}
     */
    ClientDTO INFO_BY_CODE(String code) throws SystemException;
}
