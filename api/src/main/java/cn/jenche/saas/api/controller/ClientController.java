/**
 *
 */
package cn.jenche.saas.api.controller;

import cn.jenche.core.Pager;
import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.ClientDTO;
import cn.jenche.saas.dto.PagerDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.ClientEntity;
import cn.jenche.saas.service.IClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月9日 上午11:37:44
 * @Description: 终端实体控制层
 */
@Api(tags = "终端管理")
@RestController
public class ClientController extends BaseController {
    private final IClientService clientService;

    @Autowired
    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @ApiOperation("列表")
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public ResponseResultDTO list(@Valid PagerDTO pagerDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<String>(bindingResult,
                () -> clientService.LIST_PAGES(new Pager<>(pagerDTO.getPageNo(), pagerDTO.getPageSize()))).send();
    }

    @ApiOperation("根据code获取数据")
    @ApiImplicitParam(paramType = "path", name = "clientCode", value = "终端编码", required = true)
    @RequestMapping(value = "/client/{clientCode}", method = RequestMethod.GET)
    public ResponseResultDTO byCode(@PathVariable(name = "clientCode") String clientCode) throws SystemException {
        ClientDTO clientDTO = clientService.INFO_BY_CODE(clientCode);
        return new ResponseResult<>(clientDTO).send();
    }

    @ApiOperation("终端保存")
    @PostMapping(value = "/client/save")
    public ResponseResultDTO save(@RequestBody @Valid ClientDTO clientDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<ClientEntity>(bindingResult, () -> clientService.SAVE(clientDTO)).send();
    }

    @ApiOperation("终端修改")
    @PostMapping(value = "/client/update")
    public ResponseResultDTO update(@RequestBody @Valid ClientDTO clientDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<ClientEntity>(bindingResult, () -> clientService.UPDATE(clientDTO)).send();
    }

    @ApiOperation("终端删除")
    @PostMapping(value = "/client/delete/{id}")
    public ResponseResultDTO delete(@PathVariable(value = "id") String id) throws SystemException {
        clientService.DELETE(id);
        return new ResponseResult<ClientEntity>().succeed().send();
    }

}
