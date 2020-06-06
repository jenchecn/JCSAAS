/**
 * 
 */
package cn.jenche.saas.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.jenche.core.Pager;
import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.GoodsCategoryDTO;
import cn.jenche.saas.dto.PagerDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.GoodsCategoryEntity;
import cn.jenche.saas.service.IGoodsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月3日 下午5:27:27
 * @Description: 商品分类管理
 */
@Api(tags = "商品分类管理")
@RestController
public class GoodsCategoryController extends BaseController {
	private final IGoodsCategoryService goodsCategoryService;

	@Autowired
	public GoodsCategoryController(IGoodsCategoryService goodsCategoryService) {
		this.goodsCategoryService = goodsCategoryService;
	}

	@ApiOperation("商品分类列表")
	@RequestMapping(value = "/goodscategory", method = RequestMethod.GET)
	public ResponseResultDTO list(@Valid PagerDTO pagerDTO, BindingResult bindingResult) throws SystemException {
		return new ResponseResult<String>(bindingResult,
				() -> goodsCategoryService.LIST_PAGES(new Pager<>(pagerDTO.getPageNo(), pagerDTO.getPageSize())))
						.send();
	}
	@ApiOperation("保存")
	@PostMapping(value = "/goodscategory/save")
	public ResponseResultDTO save(@Valid GoodsCategoryDTO goodsCategoryDTO, BindingResult bindingResult)
			throws SystemException {
		return new ResponseResult<GoodsCategoryEntity>(bindingResult, () -> goodsCategoryService.SAVE(goodsCategoryDTO))
				.send();
	}

	@ApiOperation("修改")
	@PostMapping(value = "/goodscategory/update")
	public ResponseResultDTO update(@Valid GoodsCategoryDTO goodsCategoryDTO, BindingResult bindingResult)
			throws SystemException {
		return new ResponseResult<GoodsCategoryEntity>(bindingResult,
				() -> goodsCategoryService.UPDATE(goodsCategoryDTO)).send();
	}

	@ApiOperation("删除")
	@PostMapping(value = "/goodscategory/delete/{id}")
	public ResponseResultDTO delete(@PathVariable(value = "id") String id) throws SystemException {
		goodsCategoryService.DELETE(id);
		return new ResponseResult<GoodsCategoryEntity>().succeed().send();
	}
}