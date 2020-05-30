package cn.jenche.saas.api.controller;

import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.ProvinceDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.location.ProvinceEntity;
import cn.jenche.saas.service.IProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/30 11:38
 * @Description: 省/直辖市控制器
 */
@Api(tags = "地区")
@RestController
public class ProvinceController extends BaseController {
    private final IProvinceService provinceService;

    @Autowired
    public ProvinceController(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @ApiOperation("列表")
    @GetMapping(value = "/location/province")
    public ResponseResultDTO list() throws SystemException {
        List<ProvinceEntity> list = provinceService.LIST();
        return new ResponseResult<>(list).send();
    }

    @ApiOperation("保存")
    @PostMapping(value = "/location/province/save")
    public ResponseResultDTO save(@Valid ProvinceDTO provinceDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<>(
                bindingResult,
                () -> provinceService.SAVE(provinceDTO)
        ).send();
    }
}
