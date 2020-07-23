package cn.jenche.saas.service.impl;


import cn.jenche.core.ExceptionMessage;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dao.mongodb.ClientPhysicsAisleRepository;
import cn.jenche.saas.dto.ClientPhysicsAisle.ClientPhysicsAisleDTO;
import cn.jenche.saas.dto.ClientPhysicsAisle.ClientPhysicsAisleExtDTO;
import cn.jenche.saas.entity.ClientPhysicsAisleEntity;
import cn.jenche.saas.service.IClientPhysicsAisleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 上午11:28:43
 * @Description: 终端物理货道实体
 */
@Service
public class ClientPhysicsAisleServiceImpl
        extends BaseServiceImpl<ClientPhysicsAisleEntity>
        implements IClientPhysicsAisleService {

    private final ClientPhysicsAisleRepository clientPhysicsAisleRepository;

    @Autowired
    public ClientPhysicsAisleServiceImpl(MongoRepository<ClientPhysicsAisleEntity, String> repository,
                                         ClientPhysicsAisleRepository clientPhysicsAisleRepository) {
        super(repository);
        this.clientPhysicsAisleRepository = clientPhysicsAisleRepository;

    }

    @Override
    public List<ClientPhysicsAisleEntity> FIND_BY_CLIENTID(String clientId) {
        return clientPhysicsAisleRepository.findAllByClientIdOrderByAisleNumberAsc(clientId);
    }

    @Override
    public boolean existsByClientId(String clientId) {
        return clientPhysicsAisleRepository.existsByClientId(clientId);
    }

    @Override
    public List<ClientPhysicsAisleEntity> SAVE(ClientPhysicsAisleDTO clientPhysicsAisleDTO) throws SystemException {
        List<ClientPhysicsAisleExtDTO> clientPhysicsAisleExtDTOS = clientPhysicsAisleDTO.getClientPhysicsAisleExtDTOS();
        List<ClientPhysicsAisleEntity> clientPhysicsAisleEntities = new ArrayList<>();
        for (ClientPhysicsAisleExtDTO clientPhysicsAisleExtDTO : clientPhysicsAisleExtDTOS) {
            ClientPhysicsAisleEntity entity = new ClientPhysicsAisleEntity();
            entity.setClientId(clientPhysicsAisleDTO.getClientId()); // 终端Id
            entity.setAisleNumber(clientPhysicsAisleExtDTO.getAisleNumber()); //货道号码
            entity.setGoodsId(clientPhysicsAisleExtDTO.getGoodsId()); //商品id
            entity.setDiscount(clientPhysicsAisleExtDTO.getDiscount());
            entity.setInventory(clientPhysicsAisleExtDTO.getInventory());
            entity.setStatus(clientPhysicsAisleExtDTO.isStatus());
            //如果数据已经存在抛出异常
            if (existsByAisleNumberAndClientId(entity.getAisleNumber(), entity.getClientId())) {
                throw new SystemException(ExceptionMessage.S_20_DATA_EXISTS);
            }

            clientPhysicsAisleEntities.add(entity);
        }

        clientPhysicsAisleEntities = clientPhysicsAisleRepository.saveAll(clientPhysicsAisleEntities);

        return clientPhysicsAisleEntities;
    }

    @Override
    public List<ClientPhysicsAisleEntity> UPDATE(ClientPhysicsAisleDTO clientPhysicsAisleDTO) throws SystemException {
        List<ClientPhysicsAisleExtDTO> clientPhysicsAisleExtDTOS = clientPhysicsAisleDTO.getClientPhysicsAisleExtDTOS();
        List<ClientPhysicsAisleEntity> clientPhysicsAisleEntities = new ArrayList<>();
        for (ClientPhysicsAisleExtDTO clientPhysicsAisleExtDTO : clientPhysicsAisleExtDTOS) {
            ClientPhysicsAisleEntity entity = new ClientPhysicsAisleEntity();
            entity.setId(clientPhysicsAisleExtDTO.getId());
            entity.setClientId(clientPhysicsAisleDTO.getClientId()); // 终端Id
            entity.setAisleNumber(clientPhysicsAisleExtDTO.getAisleNumber()); //货道号码
            entity.setGoodsId(clientPhysicsAisleExtDTO.getGoodsId()); //商品id
            entity.setDiscount(clientPhysicsAisleExtDTO.getDiscount());
            entity.setInventory(clientPhysicsAisleExtDTO.getInventory());
            entity.setStatus(clientPhysicsAisleExtDTO.isStatus());
            entity.setModifyDate(new Date());

            //如果数据已经存在抛出异常
            if (existsByAisleNumberAndClientIdAndIdNot(entity.getAisleNumber(), entity.getClientId(), entity.getId())) {
                throw new SystemException(ExceptionMessage.S_20_UPDATE_ERROR);
            }

            clientPhysicsAisleEntities.add(entity);
        }

        clientPhysicsAisleEntities = clientPhysicsAisleRepository.saveAll(clientPhysicsAisleEntities);

        return clientPhysicsAisleEntities;
    }

    private boolean existsByAisleNumberAndClientIdAndIdNot(int aisleNumber, String clientId, String id) {
        return clientPhysicsAisleRepository.existsByAisleNumberAndClientIdAndIdNot(aisleNumber, clientId, id);
    }


    /**
     * 根据货道号码和终端Id判断数据是否存在
     *
     * @param aisleNumber 货道号码
     * @param clientId    终端Id
     * @return {@link boolean}
     */
    private boolean existsByAisleNumberAndClientId(int aisleNumber, String clientId) {
        return clientPhysicsAisleRepository.existsByAisleNumberAndClientId(aisleNumber, clientId);
    }
}

