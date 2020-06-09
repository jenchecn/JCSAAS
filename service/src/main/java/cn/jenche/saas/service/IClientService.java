package cn.jenche.saas.service;

import cn.jenche.saas.entity.ClientEntity;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 17:44
 * @Description: 终端服务
 */
public interface IClientService extends IBaseService<ClientEntity> {

	ClientEntity ONE_BYCODE(String code);
}
