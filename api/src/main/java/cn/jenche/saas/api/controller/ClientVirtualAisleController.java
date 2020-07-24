/**
 *
 */
package cn.jenche.saas.api.controller;

import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.dto.clientvirtualaisle.ClientVirtualAisleRequestDTO;
import cn.jenche.saas.dto.clientvirtualaisle.ClientVirtualAisleResponseDTO;
import cn.jenche.saas.entity.ClientVirtualAisleEntity;
import cn.jenche.saas.service.IClientVirtualAisleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 下午2:38:47
 * @Description: 终端虚拟货道控制层
 */
@Api(tags = "终端虚拟货道设置")
@RestController
public class ClientVirtualAisleController extends BaseController {
    private final IClientVirtualAisleService clientVirtualAisleService;

    @Autowired
    public ClientVirtualAisleController(IClientVirtualAisleService clientVirtualAisleService) {
        this.clientVirtualAisleService = clientVirtualAisleService;
    }

    @ApiOperation("根据终端Id获取虚拟货道")
    @GetMapping(value = "/client/aisle/virtual/{clientId}")
    public ResponseResultDTO byCode(@PathVariable(value = "clientId") String clientId) throws SystemException {
        List<ClientVirtualAisleEntity> list = clientVirtualAisleService.FIND_BY_CLIENTID(clientId);
        return new ResponseResult<>(list).send();
    }

    @ApiOperation("虚拟货道添加")
    @PostMapping(value = "/client/aisle/virtual/save")
    public ResponseResultDTO save(@RequestBody @Valid ClientVirtualAisleRequestDTO clientVirtualAisleRequestDTO, BindingResult bindingResult)
            throws SystemException {
        return new ResponseResult<>(bindingResult, () -> clientVirtualAisleService.SAVE(clientVirtualAisleRequestDTO)).send();
    }

    @ApiOperation("虚拟货道修改")
    @PostMapping(value = "/client/aisle/virtual/update")
    public ResponseResultDTO update(@RequestBody @Valid ClientVirtualAisleResponseDTO clientVirtualAisleResponseDTO, BindingResult bindingResult)
            throws SystemException {
        return new ResponseResult<>(bindingResult, () -> clientVirtualAisleService.UPDATE(clientVirtualAisleResponseDTO)).send();

    }

    @ApiOperation("虚拟货道删除")
    @PostMapping(value = "/client/aisle/virtual/delete/{id}")
    public ResponseResultDTO delete(@PathVariable(value = "id") String id) throws SystemException {
        clientVirtualAisleService.DELETE(id);
        return new ResponseResult<ClientVirtualAisleEntity>().succeed().send();
    }
}
