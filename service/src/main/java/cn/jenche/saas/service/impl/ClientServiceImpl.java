package cn.jenche.saas.service.impl;

import cn.jenche.core.ExceptionMessage;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dao.mongodb.ClientRepository;
import cn.jenche.saas.dto.ClientDTO;
import cn.jenche.saas.dto.clientphysicsaisle.ClientPhysicsAisleExtGoodsDTO;
import cn.jenche.saas.dto.clientvirtualaisle.ClientVirtualAisleDTO;
import cn.jenche.saas.entity.ClientCategoryEntity;
import cn.jenche.saas.entity.ClientEntity;
import cn.jenche.saas.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/4/20 17:46
 * @Description: 终端实体
 */
@Slf4j
@Service
public class ClientServiceImpl extends BaseServiceImpl<ClientEntity> implements IClientService {
    private final IClientPhysicsAisleService clientPhysicsAisleService;
    private final IClientVirtualAisleService clientVirtualAisleService;
    private final ClientRepository clientRepository;

    private final IClientCategoryService clientCategoryService;

    public ClientServiceImpl(MongoRepository<ClientEntity, String> repository, IClientPhysicsAisleService clientPhysicsAisleService, IClientVirtualAisleService clientVirtualAisleService, ClientRepository clientRepository, IProvinceService provinceService, ICityService cityService, IDistrictService districtService, IClientCategoryService clientCategoryService) {
        super(repository);
        this.clientPhysicsAisleService = clientPhysicsAisleService;
        this.clientVirtualAisleService = clientVirtualAisleService;
        this.clientRepository = clientRepository;

        this.clientCategoryService = clientCategoryService;
    }

    //    public Pager<ClientEntity> LIST_PAGES(Pager<ClientEntity> pager) throws SystemException {
    //        Page<ClientEntity> clientList = clientRepository.findAll(pager.getPageable());
    //        List<ClientEntity> list = new LinkedList<>(clientList.getContent());
    //        List<ClientDTO> clientDTOList = new LinkedList<>();
    //
    //        List<ClientCategoryEntity> clientCategoryEntities = clientCategoryService.FINDALL();
    //
    //        for (ClientEntity entity : list) {
    //            // 查找到终端分类
    //            ClientCategoryEntity clientCategoryEntity = clientCategoryService.findByIdWithEntitys(clientCategoryEntities, entity.getClientCategoryId());
    //            List<ClientVirtualAisleDTO> clientVirtualAisleDTOS = null; //虚拟货道配置
    //            List<ClientPhysicsAisleExtGoodsDTO> clientPhysicsAisleExtGoodsDTOS = null; //物理货道信息
    //
    //            //如果启用了虚拟货道
    //            if (entity.isEnableVirtualAisle()) {
    //                // 虚拟货道信息
    //                clientVirtualAisleDTOS = clientVirtualAisleService.GET_DTO_BY_CLIENTID(entity.getId());
    //            } else {
    //                // 物理货道信息
    //                clientPhysicsAisleExtGoodsDTOS = clientPhysicsAisleService.GET_DTO_BY_CLIENTID(entity.getId());
    //            }
    //            log.debug("{}", clientPhysicsAisleExtGoodsDTOS);
    //
    //        }
    //
    //        return null;
    //    }

    @Override
    public ClientDTO INFO_BY_CODE(String code) throws SystemException {
        // 先需要查询redis中当前设备是否在线

        ClientEntity clientEntity = ONE_BYCODE(code);

        //设备状态为禁用
        if (!clientEntity.isStatus()) {
            throw new SystemException(ExceptionMessage.S_20_CLIENT_DISENABLE);
        }

        List<ClientCategoryEntity> clientCategoryEntities = clientCategoryService.FINDALL();
        //查找到终端分类
        ClientCategoryEntity clientCategoryEntity = clientCategoryService.findByIdWithEntitys(clientCategoryEntities, clientEntity.getClientCategoryId());
        List<ClientVirtualAisleDTO> clientVirtualAisleDTOS = null; //虚拟货道配置
        List<ClientPhysicsAisleExtGoodsDTO> clientPhysicsAisleExtGoodsDTOS = null; //物理货道信息

        //如果启用了虚拟货道
        if (clientEntity.isEnableVirtualAisle()) {
            // 虚拟货道信息
            clientVirtualAisleDTOS = clientVirtualAisleService.GET_DTO_BY_CLIENTID(clientEntity.getId());
        } else {
            // 物理货道信息
            clientPhysicsAisleExtGoodsDTOS = clientPhysicsAisleService.GET_DTO_BY_CLIENTID(clientEntity.getId());
        }
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNumber(clientEntity.getNumber());
        clientDTO.setStatus(clientEntity.isStatus());
        clientDTO.setEnableVirtualAisle(clientEntity.isEnableVirtualAisle());
        clientDTO.setClientPhysicsAisleExtGoodsDTOList(clientPhysicsAisleExtGoodsDTOS);
        clientDTO.setClientVirtualAisleDTOList(clientVirtualAisleDTOS);
        clientDTO.setCreateDate(null);
        clientDTO.setModifyDate(null);

        return clientDTO;
    }

    @Override
    public ClientEntity ONE_BYCODE(String code) {
        return clientRepository.findOneByCode(code);
    }

    @Override
    public boolean existsByCategoryId(String categoryId) {
        return clientRepository.existsByClientCategoryId(categoryId);
    }

    @Override
    public ClientEntity SAVE(ClientEntity entity) throws SystemException {
        if (ONE_BYCODE(entity.getCode()) != null || oneByImei(entity.getIMei()) != null) {
            throw new SystemException(ExceptionMessage.S_20_DATA_EXISTS);
        }
        return clientRepository.save(entity);
    }

    @Override
    public ClientEntity UPDATE(ClientEntity entity) throws SystemException {
        if (StringUtils.isBlank(entity.getId())) {
            throw new SystemException(ExceptionMessage.S_20_DATA_NOTEXISTS);
        }

        return SAVE(entity);
    }

    /**
     * 根据Imei返回数据
     * <p>
     * 私有方法只在当前类中使用
     * </p>
     *
     * @param iMei 终端的Imei
     * @return {@link ClientEntity}
     */
    private ClientEntity oneByImei(String iMei) {
        return clientRepository.findByiMei(iMei);
    }

    @Override
    public void DELETE(Serializable... ids) throws SystemException {
        if (ids != null && ids.length > 0) {
            for (Serializable id : ids) {
                String _id = String.valueOf(id);
                //处理物理货道
                if (clientPhysicsAisleService.existsByClientId(_id)) {
                    throw new SystemException(ExceptionMessage.S_20_DELETE_EXISTS_PART);
                }

                //处理虚拟货道
                if (clientVirtualAisleService.existsByClientId(_id)) {
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
}

