package com.yuefeng.goods.controller;


import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.yuefeng.core.AbstractCoreController;
import com.yuefeng.goods.service.BrandService;
import com.yuefeng.pojo.Brand;

import java.util.List;


/**
*
* 品牌表 前端控制器
*
*
* @author yuefeng
* @since 2021-12-09
*/
@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController extends AbstractCoreController<Brand> {

    @Autowired
    private BrandService brandService;

    /***
     * 根据分类实现品牌列表查询
     * /brand/category/{id}  分类ID
     */
    @GetMapping(value = "/category/{id}")
    public Result<List<Brand>> findBrandByCategory(@PathVariable(value = "id")Integer categoryId){
        //调用Service查询品牌数据
        List<Brand> categoryList = brandService.findByCategory(categoryId);
        return new Result<List<Brand>>(true,StatusCode.OK,"查询成功！",categoryList);
    }
}
