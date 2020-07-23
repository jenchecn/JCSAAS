package cn.jenche.saas.service.impl;

import cn.jenche.core.ExceptionMessage;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dao.mongodb.ClientVirtualAisleRepository;
import cn.jenche.saas.dto.clientvirtualaisle.ClientVirtualAisleDTO;
import cn.jenche.saas.entity.ClientVirtualAisleEntity;
import cn.jenche.saas.entity.VirtualAisleConfigEntity;
import cn.jenche.saas.service.IClientVirtualAisleService;
import cn.jenche.saas.service.IVirtualAisleConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 下午2:37:37
 * @Description: 终端虚拟货道服务
 */
@Service
public class ClientVirtualAisleServiceImpl extends BaseServiceImpl<ClientVirtualAisleEntity>
        implements IClientVirtualAisleService {

    private final ClientVirtualAisleRepository clientVirtualAisleRepository;
    private final IVirtualAisleConfigService virtualAisleConfigService;

    @Autowired
    public ClientVirtualAisleServiceImpl(MongoRepository<ClientVirtualAisleEntity, String> repository,
                                         ClientVirtualAisleRepository clientVirtualAisleRepository, IVirtualAisleConfigService virtualAisleConfigService) {
        super(repository);
        this.clientVirtualAisleRepository = clientVirtualAisleRepository;

        this.virtualAisleConfigService = virtualAisleConfigService;
    }

    @Override
    public List<ClientVirtualAisleEntity> FIND_BY_CLIENTID(String clientId) {
        return clientVirtualAisleRepository.findAllByClientId(clientId);
    }

    @Override
    public boolean existsByClientId(String clientId) {
        return clientVirtualAisleRepository.existsByClientId(clientId);
    }

    @Override
    public List<ClientVirtualAisleDTO> GET_DTO_BY_CLIENTID(String clientId) throws SystemException {
        List<ClientVirtualAisleEntity> clientVirtualAisleEntities = FIND_BY_CLIENTID(clientId);
        List<ClientVirtualAisleDTO> clientVirtualAisleDTOS = new LinkedList<>();

        for (ClientVirtualAisleEntity clientVirtualAisleEntity : clientVirtualAisleEntities) {
            //获取虚拟货道配置信息
            VirtualAisleConfigEntity virtualAisleConfigEntity = virtualAisleConfigService.ONE_BYID(clientVirtualAisleEntity.getVirtualAisleConfigId());
            if (virtualAisleConfigEntity == null) {
                throw new SystemException(ExceptionMessage.S_20_DATA_NOTEXISTS);
            }

            ClientVirtualAisleDTO clientVirtualAisleDTO = new ClientVirtualAisleDTO();
            clientVirtualAisleDTO.setName(virtualAisleConfigEntity.getName());
            clientVirtualAisleDTO.setDesc(virtualAisleConfigEntity.getDesc());
            clientVirtualAisleDTO.setImage(virtualAisleConfigEntity.getImage());
            clientVirtualAisleDTO.setSellPrice(clientVirtualAisleEntity.getSellPrice());
            clientVirtualAisleDTOS.add(clientVirtualAisleDTO);
        }
        return clientVirtualAisleDTOS;
    }
}
