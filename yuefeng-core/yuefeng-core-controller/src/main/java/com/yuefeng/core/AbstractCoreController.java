package com.yuefeng.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public abstract class AbstractCoreController<T> implements ICoreController<T> {


    @Autowired
    public BaseMapper<T> baseMapper;


    /**
     * 删除记录
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @Override
    public Result deleteById(@PathVariable(name = "id") long id) {
        baseMapper.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 添加记录
     *
     * @param record
     * @return
     */
    @PostMapping
    @Override
    public Result insert(@RequestBody T record) {
        baseMapper.insert(record);
        return new Result(true, StatusCode.OK, "添加成功");
    }


    /**
     * 多条件搜索品牌数据
     * @param brand
     * @return
     */
    @PostMapping("/search")
    public Result<List<T>> findList(@RequestBody T brand){
        List<T> brands = baseMapper.selectList(new QueryWrapper<>(brand));
        return new Result<List<T>>(true, StatusCode.OK,"多条件搜索品牌数据成功！");
    }

    /**
     * 分页查询记录
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    @Override
    public Result<IPage<T>> findByPage(@PathVariable(name = "page") long pageNo,
                                       @PathVariable(name = "size") long pageSize) {
        Page<T> pageInfo = baseMapper.selectPage(new Page<T>(pageNo, pageSize),null);
        System.out.println("分页查询");
        return new Result<IPage<T>>(true, StatusCode.OK, "分页查询成功", pageInfo);
    }

    @PostMapping(value = "/search/{page}/{size}")
    @Override
    public Result<IPage<T>> findByPage(@PathVariable(name = "page") long pageNo,
                                          @PathVariable(name = "size") long pageSize,
                                          @RequestBody T record) {
        IPage<T> pageInfo = baseMapper.selectPage(new Page<T>(pageNo, pageSize), new QueryWrapper<T>(record));

        return new Result<IPage<T>>(true, StatusCode.OK, "条件分页查询成功", pageInfo);
    }

    @Override
    @GetMapping("/{id}")
    public Result<T> findById(@PathVariable(name = "id") long id) {
        T t = baseMapper.selectById(id);
        return new Result<T>(true, StatusCode.OK, "查询单个数据成功", t);
    }

    @Override
    @GetMapping
    public Result<List<T>> findAll() {
        List<T> list = baseMapper.selectList(null);
        return new Result<List<T>>(true, StatusCode.OK, "查询所有数据成功", list);
    }

    //更新数据
    @Override
    @PutMapping
    public Result updateByPrimaryKey(@RequestBody T record) {
        baseMapper.update(record,null);
        return new Result(true, StatusCode.OK, "更新成功");
    }
}
