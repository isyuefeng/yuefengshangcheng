package com.yuefeng.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class AbstractCoreController<T> implements ICoreController<T> {


    @Autowired
    public IService<T> iService;


    /**
     * 删除记录
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @Override
    public Result deleteById(@PathVariable(name = "id") long id) {
        iService.removeById(id);
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
        iService.save(record);
        return new Result(true, StatusCode.OK, "添加成功");
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
        IPage<T> pageInfo = iService.page(new Page<T>(pageNo, pageSize));
        return new Result<IPage<T>>(true, StatusCode.OK, "分页查询成功", pageInfo);
    }

    @PostMapping(value = "/search/{page}/{size}")
    @Override
    public Result<IPage<T>> findByPage(@PathVariable(name = "page") long pageNo,
                                          @PathVariable(name = "size") long pageSize,
                                          @RequestBody T record) {
        IPage<T> pageInfo = iService.page(new Page<T>(pageNo, pageSize), new QueryWrapper<T>(record));

        return new Result<IPage<T>>(true, StatusCode.OK, "条件分页查询成功", pageInfo);
    }

    @Override
    @GetMapping("/{id}")
    public Result<T> findById(@PathVariable(name = "id") long id) {
        T t = iService.getById(id);
        return new Result<T>(true, StatusCode.OK, "查询单个数据成功", t);
    }

    @Override
    @GetMapping
    public Result<List<T>> findAll() {
        List<T> list = iService.list(null);
        return new Result<List<T>>(true, StatusCode.OK, "查询所有数据成功", list);
    }

    //更新数据
    @Override
    @PutMapping
    public Result updateByPrimaryKey(@RequestBody T record) {
        iService.update(new QueryWrapper<>(record));
        return new Result(true, StatusCode.OK, "更新成功");
    }
}
