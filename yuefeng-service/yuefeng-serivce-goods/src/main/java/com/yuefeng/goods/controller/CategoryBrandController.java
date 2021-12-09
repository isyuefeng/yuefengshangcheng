package com.yuefeng.goods.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import com.yuefeng.core.AbstractCoreController;
import com.yuefeng.goods.service.CategoryBrandService;
import com.yuefeng.pojo.CategoryBrand;


/**
*
*  前端控制器
*
*
* @author yuefeng
* @since 2021-12-09
*/
@CrossOrigin
@RestController
@RequestMapping("/categoryBrand")
public class CategoryBrandController extends AbstractCoreController<CategoryBrand> {

    @Autowired
    private CategoryBrandService categoryBrandService;
}
