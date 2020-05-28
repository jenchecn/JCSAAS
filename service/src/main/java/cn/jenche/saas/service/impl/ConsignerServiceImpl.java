package cn.jenche.saas.service.impl;

import cn.jenche.core.ExceptionMessage;
import cn.jenche.core.Pager;
import cn.jenche.core.SystemException;
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
public class ConsignerServiceImpl implements IConsignerService {
    private final ConsignerRepository consignerRepository;

    @Autowired
    public ConsignerServiceImpl(ConsignerRepository consignerRepository) {
        this.consignerRepository = consignerRepository;
    }

    @Override
    public ConsignerEntity ONE_BYID(String id) throws SystemException {
        throw new SystemException(ExceptionMessage.S_20_NOT_IMPLEMENT);
    }

    @Override
    public Pager<ConsignerEntity> LIST_PAGES(Pager<ConsignerEntity> pager) throws SystemException {
        throw new SystemException(ExceptionMessage.S_20_NOT_IMPLEMENT);
    }

    @Override
    public ConsignerEntity SAVE(ConsignerEntity entity) throws SystemException {
        //throw new SystemException(ExceptionMessage.S_20_NOT_IMPLEMENT);
        return consignerRepository.save(entity);
    }

    @Override
    public ConsignerEntity UPDATE(ConsignerEntity entity) throws SystemException {
        throw new SystemException(ExceptionMessage.S_20_NOT_IMPLEMENT);
    }

    @Override
    public void DELETE(String id) throws SystemException {
        throw new SystemException(ExceptionMessage.S_20_NOT_IMPLEMENT);
    }
}
