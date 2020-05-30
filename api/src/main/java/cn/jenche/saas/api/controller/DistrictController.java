/**
 *
 */
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
import cn.jenche.saas.dto.DistrictDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.location.DistrictEntity;
import cn.jenche.saas.service.IDistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年5月30日 下午4:58:09
 * @Description: 区/镇服务
 */
@Api(tags = "区域")
@RestController
public class DistrictController extends BaseController{
	private final IDistrictService districtService;
	
	@Autowired
	public DistrictController(IDistrictService districtService) {
		this.districtService=districtService;
	}
	@ApiOperation("区/镇列表")
    @GetMapping(value = "/location/district")
	 public ResponseResultDTO list() throws SystemException {
        List<DistrictEntity> list = districtService.LIST();
        return new ResponseResult<>(list).send();
    }
	 @ApiOperation("区/镇添加")
	    @PostMapping(value = "/location/district/save")
	    public ResponseResultDTO save(@Valid DistrictDTO districtDTO, BindingResult bindingResult) throws SystemException {
	       return new ResponseResult<>(
	                bindingResult,
	                () -> districtService.SAVE(districtDTO)
	        ).send();
	    }
	 @ApiOperation("区/镇修改")
	    @PostMapping(value="/loscation/district/update")
	    public ResponseResultDTO update(@Valid DistrictDTO districtDTO,BindingResult bindingResult) throws SystemException{
	    	return new ResponseResult<>(
	    			bindingResult,
	    			() -> districtService.UPDATE(districtDTO)
	    			).send();
	    }
}
