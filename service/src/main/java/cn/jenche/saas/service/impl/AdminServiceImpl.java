/**
 *
 */
package cn.jenche.saas.service.impl;

import cn.jenche.core.ExceptionMessage;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dao.mongodb.AdminRepository;
import cn.jenche.saas.entity.AdminEntity;
import cn.jenche.saas.service.IAdminService;
import cn.jenche.utility.EncryptUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月1日 下午3:58:29
 * @Description: 管理员服务
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<AdminEntity> implements IAdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(MongoRepository<AdminEntity, String> repository, AdminRepository adminRepository) {
        super(repository);
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminEntity SAVE(AdminEntity entity) throws SystemException {
        //检查用户是否已经存在过
        boolean isExist = adminRepository.existsByName(entity.getName());
        if (isExist) {
            throw new SystemException(ExceptionMessage.S_20_DATA_EXISTS);
        }

        String passWord = entity.getPassword();
        passWord = EncryptUtility.getSha(passWord, null);
        entity.setPassword(passWord);

        return adminRepository.save(entity);
    }

    @Override
    public List<AdminEntity> LIST() {
        return repository.findAll();
    }
}
