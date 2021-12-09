package com.yuefeng.goods.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuefeng.pojo.Goods;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.yuefeng.core.AbstractCoreController;
import com.yuefeng.goods.service.SpuService;
import com.yuefeng.pojo.Spu;


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
@RequestMapping("/spu")
public class SpuController extends AbstractCoreController<Spu> {

    @Autowired
    private SpuService spuService;

    /***
     * 添加Goods
     * @param goods
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody Goods goods){
        spuService.saveGoods(goods);
        return new Result(true, StatusCode.OK,"保存成功");
    }


    /***
     * 根据ID查询Goods
     * @param id
     * @return
     */
    @GetMapping("/goods/{id}")
    public Result<Goods> findGoodsById(@PathVariable Long id){
        //根据ID查询Goods(SPU+SKU)信息
        Goods goods = spuService.findGoodsById(id);
        return new Result<Goods>(true,StatusCode.OK,"查询成功",goods);
    }

    /**
     * 审核
     * @param id
     * @return
     */
    @PutMapping("/audit/{id}")
    public Result audit(@PathVariable Long id){
        spuService.audit(id);
        return new Result(true,StatusCode.OK,"审核成功");
    }

    /**
     * 下架
     * @param id
     * @return
     */
    @PutMapping("/pull/{id}")
    public Result pull(@PathVariable Long id){
        spuService.pull(id);
        return new Result(true,StatusCode.OK,"下架成功");
    }


    /**
     * 商品上架
     * @param id
     * @return
     */
    @PutMapping("/put/{id}")
    public Result put(@PathVariable Long id){
        spuService.put(id);
        return new Result(true,StatusCode.OK,"上架成功");
    }

    /**
     *  批量上架
     * @param ids:需要上架的商品ID集合
     * @return
     */
    @PutMapping("/put/many")
    public Result putMany(@RequestBody Long[] ids){
        int count = spuService.putMany(ids);
        return new Result(true,StatusCode.OK,"上架"+count+"个商品");
    }

    /**
     * 批量下架
     * @param ids:需要下架的商品ID集合
     * @return
     */
    @PutMapping("/pull/many")
    public Result pull(@RequestBody Long[] ids){
        spuService.pullMany(ids);
        return new Result(true,StatusCode.OK,"下架成功");
    }

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    @DeleteMapping("/logic/delete/{id}")
    public Result logicDelete(@PathVariable Long id){
        spuService.logicDelete(id);
        return new Result(true,StatusCode.OK,"逻辑删除成功！");
    }

    /**
     * 恢复数据
     * @param id
     * @return
     */
    @PutMapping("/restore/{id}")
    public Result restore(@PathVariable Long id){
        spuService.restore(id);
        return new Result(true,StatusCode.OK,"数据恢复成功！");
    }

    /***
     * Spu分页条件搜索实现
     * @param spu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<IPage> findPage(@RequestBody(required = false) Spu spu, @PathVariable long page, @PathVariable  long size){
        //执行搜索
        IPage<Spu> pageInfo = spuService.page(new Page<>(page,size),new QueryWrapper<>(spu));
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }
}
