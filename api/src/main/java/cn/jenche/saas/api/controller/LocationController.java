package cn.jenche.saas.api.controller;

import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.CityDTO;
import cn.jenche.saas.dto.DistrictDTO;
import cn.jenche.saas.dto.ProvinceDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.location.CityEntity;
import cn.jenche.saas.entity.location.DistrictEntity;
import cn.jenche.saas.entity.location.ProvinceEntity;
import cn.jenche.saas.service.ICityService;
import cn.jenche.saas.service.IDistrictService;
import cn.jenche.saas.service.IProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/6/2 15:41
 * @Description: 区域控制器
 */
@Api(tags = "区域")
@RestController
public class LocationController extends BaseController {
    private final IProvinceService provinceService;
    private final ICityService cityService;
    private final IDistrictService districtService;

    @Autowired
    public LocationController(IProvinceService provinceService, ICityService cityService, IDistrictService districtService) {
        this.provinceService = provinceService;
        this.cityService = cityService;
        this.districtService = districtService;
    }

    //区域中的省、直辖市
    @ApiOperation("省/直辖市列表")
    @GetMapping(value = "/location/province")
    public ResponseResultDTO provinceList() throws SystemException {
        List<ProvinceEntity> list = provinceService.LIST();
        return new ResponseResult<>(list).send();
    }

    @ApiOperation("根据ID获取省/直辖市")
    @PostMapping(value = "/location/province/{id}")
    public ResponseResultDTO provinceById(@PathVariable(value = "id") String id) throws SystemException {
        ProvinceEntity entity = provinceService.ONE_BYID(id);
        return new ResponseResult<>(entity).send();
    }

    @ApiOperation("省/直辖市添加")
    @PostMapping(value = "/location/province/save")
    public ResponseResultDTO provinceSave(@Valid ProvinceDTO provinceDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<>(
                bindingResult,
                () -> provinceService.SAVE(provinceDTO)
        ).send();
    }

    @ApiOperation("省/直辖市修改")
    @PostMapping(value = "/location/province/update")
    public ResponseResultDTO provinceUpdate(@Valid ProvinceDTO provinceDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<>(
                bindingResult,
                () -> provinceService.UPDATE(provinceDTO)
        ).send();
    }

    //区域中的省、直辖市结束
    //==============================================================================================
    //区域中的市县
    //    @ApiOperation("市/县列表")
    //    @GetMapping(value = "/location/city")
    //    public ResponseResultDTO cityList() throws SystemException {
    //        List<CityEntity> list = cityService.LIST();
    //        return new ResponseResult<>(list).send();
    //    }

    @ApiOperation("根据ParentId获取市县列表")
    @GetMapping(value = "/location/city/byparent/{parentId}")
    public ResponseResultDTO cityByParentId(@PathVariable(value = "parentId") String parentId) throws SystemException {
        List<CityEntity> list = cityService.LIST_BYPARENTID(parentId);
        return new ResponseResult<>(list).send();
    }

    @ApiOperation("根据ID获取市/县")
    @PostMapping(value = "/location/city/byid/{id}")
    public ResponseResultDTO cityById(@PathVariable(value = "id") String id) throws SystemException {
        CityEntity entity = cityService.ONE_BYID(id);
        return new ResponseResult<>(entity).send();
    }

    @ApiOperation("市/县添加")
    @PostMapping(value = "/location/city/save")
    public ResponseResultDTO citySave(@Valid CityDTO cityDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<>(bindingResult,
                () -> cityService.SAVE(cityDTO)
        ).send();

    }

    @ApiOperation("市/县修改")
    @PostMapping(value = "/location/city/update")
    public ResponseResultDTO cityUpdate(@Valid CityDTO cityDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<>(
                bindingResult,
                () -> cityService.UPDATE(cityDTO)
        ).send();
    }

    //市县结束
    //==============================================================================================
    //区镇控制器
    @ApiOperation("根据ParentId获取区镇列表")
    @GetMapping(value = "/location/city/bydistrict/{parentId}")
    public ResponseResultDTO districtByParentId(@PathVariable(value = "parentId") String parentId) throws SystemException {
        List<DistrictEntity> list = districtService.LIST_BYPARENTID(parentId);
        return new ResponseResult<>(list).send();
    }

    @ApiOperation("区/镇添加")
    @PostMapping(value = "/location/district/save")
    public ResponseResultDTO districtSave(@Valid DistrictDTO districtDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<>(
                bindingResult,
                () -> districtService.SAVE(districtDTO)
        ).send();
    }

    @ApiOperation("区/镇修改")
    @PostMapping(value = "/loscation/district/update")
    public ResponseResultDTO districtUpdate(@Valid DistrictDTO districtDTO, BindingResult bindingResult) throws SystemException {
        return new ResponseResult<>(
                bindingResult,
                () -> districtService.UPDATE(districtDTO)
        ).send();
    }
    //区镇控制器结束
}
