
package cn.jenche.saas.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.CityDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.location.CityEntity;
import cn.jenche.saas.service.ICityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年5月30日 下午3:02:41
 * @Description: 市/县 
 */
@Api(tags = "市/县")
@RestController
public class CityController extends BaseController {
	private final ICityService cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @ApiOperation("市/县列表")
    @GetMapping(value = "/location/city")
    public ResponseResultDTO list() throws SystemException {
        List<CityEntity> list = cityService.LIST();
        return new ResponseResult<>(list).send();
    }

    @ApiOperation("市/县添加")
    @PostMapping(value = "/location/city/save")
    public ResponseResultDTO save(@Valid CityDTO cityDTO, BindingResult bindingResult) throws SystemException {
    	return new ResponseResult<>(bindingResult,
    			()->cityService.SAVE(cityDTO)
    			).send();
        
    }
    @ApiOperation("市/县修改")
    @PostMapping(value="/location/city/update")
    public ResponseResultDTO update(@Valid CityDTO cityDTO,BindingResult bindingResult) throws SystemException{
    	return new ResponseResult<>(
    			bindingResult,
    			() -> cityService.UPDATE(cityDTO)
    			).send();
    }
}
