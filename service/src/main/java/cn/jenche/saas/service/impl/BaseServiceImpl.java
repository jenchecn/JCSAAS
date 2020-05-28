package cn.jenche.saas.service.impl;

import cn.jenche.core.ExceptionMessage;
import cn.jenche.core.Pager;
import cn.jenche.core.SystemException;
import cn.jenche.saas.service.IBaseService;
import cn.jenche.utility.GenericsUtility;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/28 10:37
 * @Description: 公共服务类
 */
public abstract class BaseServiceImpl<E> implements IBaseService<E> {
    protected final MongoRepository<E, String> repository;

    public BaseServiceImpl(MongoRepository<E, String> repository) {
        this.repository = repository;
    }

    @Override
    public E ONE_BYID(String id) throws SystemException {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Pager<E> LIST_PAGES(Pager<E> pager) throws SystemException {
        return pager.convert(repository.findAll(pager.getPageable()));
    }

    @Override
    public E SAVE(E entity) throws SystemException {
        return repository.save(entity);
    }

    @Override
    public E UPDATE(E entity) throws SystemException {
        Object o = GenericsUtility.GetInstance().findFieldBy(entity, "id");
        if (o == null) {
            throw new SystemException(ExceptionMessage.S_20_FINDFIELD_ERROR);
        }

        String _id = o.toString();

        if (repository.existsById(_id)) {
            return SAVE(entity);
        }

        throw new SystemException(ExceptionMessage.S_20_DATA_NOTEXISTS);
    }

    @Override
    public void DELETE(Serializable... ids) throws SystemException {
        if (ids != null && ids.length > 0) {
            for (Serializable id : ids) {
                String _id = String.valueOf(id);
                if (repository.existsById(_id)) {
                    repository.deleteById(_id);
                }
            }
            return;
        }
        
        throw new SystemException(ExceptionMessage.S_20_DELETE_ERROR);
    }
}
