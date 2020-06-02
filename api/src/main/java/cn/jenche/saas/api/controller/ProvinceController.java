package cn.jenche.saas.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.ProvinceDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.location.ProvinceEntity;
import cn.jenche.saas.service.IProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/30 11:38
 * @Description: 省/直辖市控制器
 */
@Api(tags = "区域")
@RestController
public class ProvinceController extends BaseController {
    private final IProvinceService provinceService;

    @Autowired
    public ProvinceController(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @ApiOperation("省/直辖市列表")
    @GetMapping(value = "/location/province")
    public ResponseResultDTO list() throws SystemException {
        List<ProvinceEntity> list = provinceService.LIST();
        return new ResponseResult<>(list).send();
    }

	@ApiOperation("根据ID获取省/直辖市")
	@PostMapping(value = "/location/province/{id}")
	public ResponseResultDTO byId(@PathVariable(value = "id") String id) throws SystemException {
		ProvinceEntity entity = provinceService.ONE_BYID(id);
		return new ResponseResult<>(entity).send();
	}

    @ApiOperation("省/直辖市添加")
    @PostMapping(value = "/location/province/save")
    public ResponseResultDTO save(@Valid ProvinceDTO provinceDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<>(
                bindingResult,
                () -> provinceService.SAVE(provinceDTO)
        ).send();
    }
    @ApiOperation("省/直辖市修改")
	@PostMapping(value = "/location/province/update")
    public ResponseResultDTO update(@Valid ProvinceDTO provinceDTO,BindingResult bindingResult) throws SystemException{
    	return new ResponseResult<>(
    			bindingResult,
    			() -> provinceService.UPDATE(provinceDTO)
    			).send();
    }
}
