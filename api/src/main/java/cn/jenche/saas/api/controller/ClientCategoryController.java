package cn.jenche.saas.api.controller;

import cn.jenche.core.Pager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/19 12:55
 * @Description: 终端分类控制器
 */
@Api(tags = "终端分类管理")
@RestController
public class ClientCategoryController extends BaseController {

    @ApiOperation("列表")

    @RequestMapping(value = "/client/category", method = RequestMethod.GET)
    public ResponseEntity<?> list(Pager pager) {
        return new ResponseEntity<Object>("ok", HttpStatus.OK);
    }
}
