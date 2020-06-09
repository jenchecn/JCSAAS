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
import cn.jenche.saas.dto.ClientPhysicsAisleDTO;
import cn.jenche.saas.dto.PagerDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.ClientPhysicsAisleEntity;
import cn.jenche.saas.service.IClientPhysicsAisleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 上午11:30:06
 * @Description: 终端物理货道控制层
 */
@Api(tags = "终端物理货道")
@RestController
public class ClientPhysicsAisleController extends BaseController {
	private final IClientPhysicsAisleService clientPhysicsAisleService;

	@Autowired
	public ClientPhysicsAisleController(IClientPhysicsAisleService clientPhysicsAisleService) {
		this.clientPhysicsAisleService = clientPhysicsAisleService;
	}

	@ApiOperation("物理货道列表")
	@GetMapping(value = "/clientPhysicsAisle")
	public ResponseResultDTO list(@Valid PagerDTO pagerDTO, BindingResult bindingResult) throws SystemException {
		return new ResponseResult<String>(bindingResult,
				() -> clientPhysicsAisleService.LIST_PAGES(new Pager<>(pagerDTO.getPageNo(), pagerDTO.getPageSize())))
						.send();
	}

	@ApiOperation("根据终端code获取物理货道")
	@PostMapping(value = "/clientPhysicsAisle/{code}")
	public ResponseResultDTO byCode(@PathVariable(value = "code") String code) throws SystemException {
		ClientPhysicsAisleEntity entity = clientPhysicsAisleService.ONE_BYID(code);
		return new ResponseResult<>(entity).send();
	}

	@ApiOperation("物理货道添加")
	@PostMapping(value = "/clientPhysicsAisle/save")
	public ResponseResultDTO save(@Valid ClientPhysicsAisleDTO clientPhysicsAisleDTO, BindingResult bindingResult)
			throws SystemException {
		return new ResponseResult<>(bindingResult, () -> clientPhysicsAisleService.SAVE(clientPhysicsAisleDTO)).send();
	}

	@ApiOperation("物理货道修改")
	@PostMapping(value = "/clientPhysicsAisle/update")
	public ResponseResultDTO update(@Valid ClientPhysicsAisleDTO clientPhysicsAisleDTO, BindingResult bindingResult)
			throws SystemException {
		return new ResponseResult<>(bindingResult, () -> clientPhysicsAisleService.UPDATE(clientPhysicsAisleDTO))
				.send();

	}

	@ApiOperation("物理货道删除")
	@PostMapping(value = "/clientPhysicsAisle/delete/{id}")
	public ResponseResultDTO delete(@PathVariable(value = "id") String id) throws SystemException {
		clientPhysicsAisleService.DELETE(id);
		return new ResponseResult<ClientPhysicsAisleEntity>().succeed().send();
	}
}