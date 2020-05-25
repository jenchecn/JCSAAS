package cn.jenche.saas.api.controller;

import cn.jenche.core.Pager;
import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.PagerDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.ClientCategoryEntity;
import cn.jenche.saas.service.IClientCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
        Pager<ClientCategoryEntity> list = clientCategoryService.LIST_PAGES(
                new Pager(
                        pagerDTO.getPageNo(),
                        pagerDTO.getPageSize())
        );

        return new ResponseResult<String>(bindingResult, list).build();
    }
}
