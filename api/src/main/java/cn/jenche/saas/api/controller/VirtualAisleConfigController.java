/**
 * 
 */
package cn.jenche.saas.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jenche.core.Pager;
import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.PagerDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.dto.VirtualAisleConfigDTO;
import cn.jenche.saas.entity.VirtualAisleConfigEntity;
import cn.jenche.saas.service.IVirtualAisleConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 上午9:30:55
 * @Description: 虚拟货道 控制层
 */
@Api(tags = "虚拟货道配置")
@RestController
public class VirtualAisleConfigController extends BaseController {
	private final IVirtualAisleConfigService virtualAisleConfigService;

	@Autowired
	public VirtualAisleConfigController(IVirtualAisleConfigService virtualAisleConfigService) {
		this.virtualAisleConfigService = virtualAisleConfigService;
	}

	@ApiOperation("虚拟货道列表")
	@GetMapping(value = "/virtualAisleConfig")
	public ResponseResultDTO list(@Valid PagerDTO pagerDTO, BindingResult bindingResult) throws SystemException {
		return new ResponseResult<String>(bindingResult,
				() -> virtualAisleConfigService.LIST_PAGES(new Pager<>(pagerDTO.getPageNo(), pagerDTO.getPageSize())))
						.send();
	}


	@ApiOperation("虚拟货道添加")
	@PostMapping(value = "/virtualAisleConfig/save")
	public ResponseResultDTO save(@Valid VirtualAisleConfigDTO virtualAisleConfigDTO, BindingResult bindingResult)
			throws SystemException {
		return new ResponseResult<>(bindingResult, () -> virtualAisleConfigService.SAVE(virtualAisleConfigDTO)).send();
	}

	@ApiOperation("虚拟货道修改")
	@PostMapping(value = "/virtualAisleConfig/update")
	public ResponseResultDTO update(@Valid VirtualAisleConfigDTO virtualAisleConfigDTO, BindingResult bindingResult)
			throws SystemException {
		return new ResponseResult<>(bindingResult, () -> virtualAisleConfigService.UPDATE(virtualAisleConfigDTO))
				.send();

	}

	@ApiOperation("虚拟货道删除")
	@PostMapping(value = "/virtualAisleConfig/delete/{id}")
	public ResponseResultDTO delete(@PathVariable(value = "id") String id) throws SystemException {
		virtualAisleConfigService.DELETE(id);
		return new ResponseResult<VirtualAisleConfigEntity>().succeed().send();
	}
}
