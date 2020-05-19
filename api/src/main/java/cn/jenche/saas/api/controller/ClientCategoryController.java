package cn.jenche.saas.api.controller;

import cn.jenche.core.Pager;
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
@RestController
public class ClientCategoryController extends BaseController {
    @RequestMapping(value = "/client/category/list", method = RequestMethod.GET)
    public ResponseEntity<?> list(Pager pager) {
        return null;
    }
}
