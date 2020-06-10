package cn.jenche.saas.service.impl;

import cn.jenche.core.ExceptionMessage;
import cn.jenche.core.SystemException;
import cn.jenche.saas.entity.GoodsCategoryEntity;
import cn.jenche.saas.service.IGoodsCategoryService;
import cn.jenche.saas.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月3日 下午5:19:57
 * @Description: 商品分类服务
 */
@Service
public class GoodsCategoryServiceImpl extends BaseServiceImpl<GoodsCategoryEntity> implements IGoodsCategoryService {
    private final IGoodsService goodsService;

    @Autowired
    public GoodsCategoryServiceImpl(MongoRepository<GoodsCategoryEntity, String> repository, IGoodsService goodsService) {
        super(repository);
        this.goodsService = goodsService;
    }

    @Override
    public void DELETE(Serializable... ids) throws SystemException {
        if (ids != null && ids.length > 0) {
            for (Serializable id : ids) {
                String _id = String.valueOf(id);
                if (goodsService.existsByCategoryId(_id)) {
                    throw new SystemException(ExceptionMessage.S_20_DELETE_EXISTS_PART);
                }

                if (repository.existsById(_id)) {
                    repository.deleteById(_id);
                }
            }
            return;
        }

        throw new SystemException(ExceptionMessage.S_20_DELETE_ERROR);
    }

    @Override
    public List<GoodsCategoryEntity> LIST() {
        return repository.findAll();
    }
}
