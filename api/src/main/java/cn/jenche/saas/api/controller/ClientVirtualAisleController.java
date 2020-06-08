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
import cn.jenche.saas.dto.ClientVirtualAisleDTO;
import cn.jenche.saas.dto.PagerDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.ClientVirtualAisleEntity;
import cn.jenche.saas.service.IClientVirtualAisleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月6日 下午2:38:47
 * @Description: 终端虚拟货道控制层
 */
@Api(tags = "终端虚拟货道")
@RestController
public class ClientVirtualAisleController extends BaseController {
	private final IClientVirtualAisleService clientVirtualAisleService;

	@Autowired
	public ClientVirtualAisleController(IClientVirtualAisleService clientVirtualAisleService) {
		this.clientVirtualAisleService = clientVirtualAisleService;
}

@ApiOperation("虚拟货道列表")
@GetMapping(value = "/clientVirtualAisle")
public ResponseResultDTO list(@Valid PagerDTO pagerDTO, BindingResult bindingResult) throws SystemException {
	return new ResponseResult<String>(bindingResult,
			() -> clientVirtualAisleService.LIST_PAGES(new Pager<>(pagerDTO.getPageNo(), pagerDTO.getPageSize())))
					.send();
}

@ApiOperation("根据ID获取用户")
@PostMapping(value = "/clientVirtualAisle/{id}")
public ResponseResultDTO byId(@PathVariable(value = "id") String id) throws SystemException {
	ClientVirtualAisleEntity entity = clientVirtualAisleService.ONE_BYID(id);
	return new ResponseResult<>(entity).send();
}

@ApiOperation("虚拟货道添加")
@PostMapping(value = "/clientVirtualAisle/save")
public ResponseResultDTO save(@Valid ClientVirtualAisleDTO clientVirtualAisleDTO, BindingResult bindingResult)
		throws SystemException {
	return new ResponseResult<>(bindingResult, () -> clientVirtualAisleService.SAVE(clientVirtualAisleDTO)).send();
}

@ApiOperation("虚拟货道修改")
@PostMapping(value = "/clientVirtualAisle/update")
public ResponseResultDTO update(@Valid ClientVirtualAisleDTO clientVirtualAisleDTO, BindingResult bindingResult)
		throws SystemException {
	return new ResponseResult<>(bindingResult, () -> clientVirtualAisleService.UPDATE(clientVirtualAisleDTO)).send();

}

@ApiOperation("虚拟货道删除")
@PostMapping(value = "/clientVirtualAisle/delete/{id}")
public ResponseResultDTO delete(@PathVariable(value = "id") String id) throws SystemException {
	clientVirtualAisleService.DELETE(id);
	return new ResponseResult<ClientVirtualAisleEntity>().succeed().send();
}
}