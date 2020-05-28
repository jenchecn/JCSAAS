package cn.jenche.saas.service.impl;

import cn.jenche.saas.dao.mongodb.ConsignerRepository;
import cn.jenche.saas.entity.ConsignerEntity;
import cn.jenche.saas.service.IConsignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/28 09:26
 * @Description: 委托相关服务
 */
@Service
public class ConsignerServiceImpl extends BaseServiceImpl<ConsignerEntity> implements IConsignerService {
    @Autowired
    public ConsignerServiceImpl(ConsignerRepository consignerRepository) {
        super(consignerRepository);
    }
}
