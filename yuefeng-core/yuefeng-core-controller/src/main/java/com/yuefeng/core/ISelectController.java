package com.yuefeng.core;

import entity.Result;

import java.util.List;

/***
 * @author yuefeng
 */
public interface ISelectController<T> {
    //根据ID 获取信息
    public Result<T> findById(long id);


    //根据ID 获取信息列表
    public Result<List<T>> findAll();


}
