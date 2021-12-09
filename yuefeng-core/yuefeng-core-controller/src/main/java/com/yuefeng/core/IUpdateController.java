package com.yuefeng.core;

import entity.Result;

/***
 * @author yuefeng
 */
public interface IUpdateController<T> {

    /**
     * 根据对象进行更新 根据ID
     *
     * @param record
     * @return
     */
    Result updateByPrimaryKey(T record);
}
