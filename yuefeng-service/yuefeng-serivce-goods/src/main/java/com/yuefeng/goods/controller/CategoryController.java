package com.yuefeng.goods.controller;


import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.yuefeng.core.AbstractCoreController;
import com.yuefeng.goods.service.CategoryService;
import com.yuefeng.pojo.Category;

import java.util.List;


/**
*
* 商品类目 前端控制器
*
*
* @author yuefeng
* @since 2021-12-09
*/
@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController extends AbstractCoreController<Category> {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据节点ID查询所有子节点分类集合
     * @param pid
     * @return
     */
    @GetMapping(value = "/list/{pid}")
    public Result<List<Category>> findByParentId(@PathVariable(value = "pid")Integer pid){
        //调用Service实现查询
        List<Category> categories = categoryService.findByParentId(pid);
        return new Result<List<Category>>(true, StatusCode.OK,"查询成功！",categories);
    }
}
