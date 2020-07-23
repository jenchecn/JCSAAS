package cn.jenche.saas.api.controller;

import cn.jenche.core.Pager;
import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.ClientCategoryDTO;
import cn.jenche.saas.dto.ClientCategoryTypeDTO;
import cn.jenche.saas.dto.PagerDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.ClientCategoryEntity;
import cn.jenche.saas.service.IClientCategoryService;
import cn.jenche.saas.type.ClientCategoryType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/19 12:55
 * @Description: 终端分类控制器
 */
@Api(tags = "终端分类管理")
@RestController
public class ClientCategoryController extends BaseController {
    private final IClientCategoryService clientCategoryService;

    @Autowired
    public ClientCategoryController(IClientCategoryService clientCategoryService) {
        this.clientCategoryService = clientCategoryService;
    }

    @ApiOperation("列表")
    @RequestMapping(value = "/client/category", method = RequestMethod.GET)
    public ResponseResultDTO list(@Valid PagerDTO pagerDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<String>(
                bindingResult,
                () -> clientCategoryService.LIST_PAGES(
                        new Pager<>(
                                pagerDTO.getPageNo(),
                                pagerDTO.getPageSize()))
        ).send();
    }

    @ApiOperation("根据ID获取数据")
    @GetMapping(value = "/client/category/{id}")
    public ResponseResultDTO byId(@PathVariable(value = "id") String id) throws SystemException {
        ClientCategoryEntity entity = clientCategoryService.ONE_BYID(id);
        return new ResponseResult<>(entity).send();
    }

    @ApiOperation("新增")
    @PostMapping(value = "/client/category/save")
    public ResponseResultDTO save(@RequestBody @Valid ClientCategoryDTO clientCategoryDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<ClientCategoryEntity>(
                bindingResult,
                () -> clientCategoryService.SAVE(clientCategoryDTO)
        ).send();
    }

    @ApiOperation("修改")
    @PostMapping(value = "/client/category/update")
    public ResponseResultDTO update(@RequestBody @Valid ClientCategoryDTO clientCategoryDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<ClientCategoryEntity>(
                bindingResult,
                () -> clientCategoryService.UPDATE(clientCategoryDTO)
        ).send();
    }

    @ApiOperation("删除")
    @PostMapping(value = "/client/category/delete/{id}")
    public ResponseResultDTO delete(@PathVariable(value = "id") String id) throws SystemException {
        clientCategoryService.DELETE(id);
        return new ResponseResult<ClientCategoryEntity>().succeed().send();
    }

    @ApiOperation("类型")
    @PostMapping(value = "/client/category/type")
    public ResponseResultDTO type() throws SystemException {
        List<ClientCategoryTypeDTO> list = new ArrayList<>();
        for (ClientCategoryType value : ClientCategoryType.values()) {
            ClientCategoryTypeDTO clientCategoryTypeDTO = new ClientCategoryTypeDTO() {{
                setName(value.name());
                setCode(value.getCode());
                setDesc(value.getDesc());
            }};
            list.add(clientCategoryTypeDTO);
        }
        return new ResponseResult<>(list).send();
    }
}
