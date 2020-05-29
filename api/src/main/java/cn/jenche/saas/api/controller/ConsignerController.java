package cn.jenche.saas.api.controller;

import cn.jenche.core.Pager;
import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.ConsignerDTO;
import cn.jenche.saas.dto.PagerDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.ClientCategoryEntity;
import cn.jenche.saas.entity.ConsignerEntity;
import cn.jenche.saas.service.IConsignerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/28 09:57
 * @Description: 委托管理web控制器
 */
@RestController
@Api(tags = "委托管理")
public class ConsignerController extends BaseController {
    private final IConsignerService consignerService;

    @Autowired
    public ConsignerController(IConsignerService consignerService) {
        this.consignerService = consignerService;
    }

    @ApiOperation("列表")
    @RequestMapping(value = "/consigner", method = RequestMethod.GET)
    public ResponseResultDTO list(@Valid PagerDTO pagerDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<String>(
                bindingResult,
                () -> consignerService.LIST_PAGES(
                        new Pager<>(
                                pagerDTO.getPageNo(),
                                pagerDTO.getPageSize()))
        ).send();
    }

    @ApiOperation("根据ID获取数据")
    @PostMapping("/consigner/{id}")
    public ResponseResultDTO byId(@PathVariable(value = "id") String id) throws SystemException {
        ConsignerEntity entity = consignerService.ONE_BYID(id);
        return new ResponseResult<>(entity).send();
    }

    @ApiOperation("保存")
    @PostMapping("/consigner/save")
    public ResponseResultDTO save(@Valid ConsignerDTO dto, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<>(
                bindingResult,
                () -> consignerService.SAVE(dto)
        ).send();
    }

    @ApiOperation("删除")
    @GetMapping("/consigner/{id}")
    public ResponseResultDTO delete(@PathVariable(value = "id") String id) throws SystemException {
        consignerService.DELETE(id);
        return new ResponseResult<ClientCategoryEntity>().succeed().send();
    }

    @ApiOperation("更新")
    @PostMapping("/consigner/udpate")
    public ResponseResultDTO update(@Valid ConsignerDTO dto, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<>(
                bindingResult,
                () -> consignerService.UPDATE(dto)
        ).send();
    }
}
