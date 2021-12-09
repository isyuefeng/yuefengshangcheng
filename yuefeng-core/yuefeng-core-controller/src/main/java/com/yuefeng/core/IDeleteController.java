package com.yuefeng.core;

import entity.Result;

/***
 * @author yuefeng
 */
public interface IDeleteController<T> {
    /**
     * 根据ID 删除
     *
     * @param id
     * @return
     */
    Result deleteById(long id);
}
