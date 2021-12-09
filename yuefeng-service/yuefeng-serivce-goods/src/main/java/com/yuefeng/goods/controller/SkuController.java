package com.yuefeng.goods.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import com.yuefeng.core.AbstractCoreController;
import com.yuefeng.goods.service.SkuService;
import com.yuefeng.pojo.Sku;


/**
*
* 商品表 前端控制器
*
*
* @author yuefeng
* @since 2021-12-09
*/
@CrossOrigin
@RestController
@RequestMapping("/sku")
public class SkuController extends AbstractCoreController<Sku> {

    @Autowired
    private SkuService skuService;
}
