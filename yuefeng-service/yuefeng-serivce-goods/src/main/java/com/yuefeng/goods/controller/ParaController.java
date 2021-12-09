package com.yuefeng.goods.controller;


import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.yuefeng.core.AbstractCoreController;
import com.yuefeng.goods.service.ParaService;
import com.yuefeng.pojo.Para;

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
@RequestMapping("/para")
public class ParaController extends AbstractCoreController<Para> {

    @Autowired
    private ParaService paraService;

    /**
     * 根据分类ID查询参数列表
     * @param id
     * @return
     */
    @GetMapping(value = "/category/{id}")
    public Result<List<Para>> getByCategoryId(@PathVariable(value = "id")Integer id){
        //根据分类ID查询对应的参数信息
        List<Para> paras = paraService.findByCategoryId(id);
        Result<List<Para>> result = new Result<List<Para>>(true, StatusCode.OK,"查询分类对应的品牌成功！",paras);
        return result;
    }
}
