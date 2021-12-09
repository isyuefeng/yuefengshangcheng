package com.yuefeng.goods.controller;


import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.yuefeng.core.AbstractCoreController;
import com.yuefeng.goods.service.SpecService;
import com.yuefeng.pojo.Spec;

import java.util.List;


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
@RequestMapping("/spec")
public class SpecController extends AbstractCoreController<Spec> {

    @Autowired
    private SpecService specService;

    /***
     * 根据分类ID查询对应的规格列表
     */
    @GetMapping(value = "/category/{id}")
    public Result<List<Spec>> findByCategoryId(@PathVariable(value = "id")Integer categoryid){
        //调用Service查询
        List<Spec> specs = specService.findByCategoryId(categoryid);
        return new Result<List<Spec>>(true, StatusCode.OK,"查询成功",specs);
    }
}
