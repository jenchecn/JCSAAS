/**
 * 
 */
package cn.jenche.saas.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.jenche.core.Pager;
import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.GoodsDTO;
import cn.jenche.saas.dto.PagerDTO;
import cn.jenche.saas.dto.ResponseResultDTO;
import cn.jenche.saas.entity.GoodsEntity;
import cn.jenche.saas.service.IGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: Alena
 * @Date: 2020年6月3日 下午3:28:51
 * @Description: 商品分类控制器
 */

@Api(tags = "商品管理")
@RestController
public class GoodsController extends BaseController {
	private final IGoodsService goodsService;

	@Autowired
	public GoodsController(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@ApiOperation("商品列表")
	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public ResponseResultDTO list(@Valid PagerDTO pagerDTO, BindingResult bindingResult) throws SystemException {
		return new ResponseResult<String>(bindingResult,
				() -> goodsService.LIST_PAGES(new Pager<>(pagerDTO.getPageNo(), pagerDTO.getPageSize()))).send();
	}



	@ApiOperation("添加")
	@PostMapping(value = "/goods/save")
	public ResponseResultDTO save(@Valid GoodsDTO goodsDTO, BindingResult bindingResult) throws SystemException {
		return new ResponseResult<GoodsEntity>(bindingResult, () -> goodsService.SAVE(goodsDTO)).send();
	}

	@ApiOperation("修改")
	@PostMapping(value = "/goods/update")
	public ResponseResultDTO update(@Valid GoodsDTO goodsDTO, BindingResult bindingResult) throws SystemException {
		return new ResponseResult<GoodsEntity>(bindingResult, () -> goodsService.UPDATE(goodsDTO)).send();
	}
}
