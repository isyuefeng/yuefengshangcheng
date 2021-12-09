package com.yuefeng.goods.controller;


import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.yuefeng.core.AbstractCoreController;
import com.yuefeng.goods.service.TemplateService;
import com.yuefeng.pojo.Template;


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
@RequestMapping("/template")
public class TemplateController extends AbstractCoreController<Template> {

    @Autowired
    private TemplateService templateService;


    /***
     * 根据分类查询模板数据
     * @param id:分类ID
     */
    @GetMapping(value = "/category/{id}")
    public Result<Template> findByCategoryId(@PathVariable(value = "id")Integer id){
        //调用Service查询
        Template template = templateService.findByCategoryId(id);
        return new Result<Template>(true, StatusCode.OK,"查询成功",template);
    }
}
