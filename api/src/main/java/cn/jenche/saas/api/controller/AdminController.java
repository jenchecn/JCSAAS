/**
 * 
 */
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
import cn.jenche.saas.dto.AdminDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.location.AdminEntity;
import cn.jenche.saas.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月1日 下午7:25:20
 * @Description: 管理员控制层
 */
@Api(tags = "管理员")
@RestController
public class AdminController extends BaseController {
	private final IAdminService adminService;

	@Autowired
	public AdminController(IAdminService adminService) {
		this.adminService = adminService;
	}

	@ApiOperation("管理员列表")
	@GetMapping(value = "/location/admin")
	public ResponseResultDTO list() throws SystemException {
		List<AdminEntity> list = adminService.LIST();
		return new ResponseResult<>(list).send();
	}

	@ApiOperation("根据ID获取用户")
	@PostMapping(value = "/location/admin/{id}")
	public ResponseResultDTO byId(@PathVariable(value = "id") String id) throws SystemException {
		AdminEntity entity = adminService.ONE_BYID(id);
		return new ResponseResult<>(entity).send();
	}

	@ApiOperation("管理员添加")
	@PostMapping(value = "/location/admin/save")
	public ResponseResultDTO save(@Valid AdminDTO adminDTO, BindingResult bindingResult) throws SystemException {
		return new ResponseResult<>(bindingResult, () -> adminService.SAVE(adminDTO)).send();
	}

	@ApiOperation("管理员修改")
	@PostMapping(value = "/location/admin/update")
	public ResponseResultDTO update(@Valid AdminDTO adminDTO, BindingResult bindingResult) throws SystemException {
		return new ResponseResult<>(bindingResult, () -> adminService.UPDATE(adminDTO)).send();

	}
}
