package com.yuefeng.core;

import entity.Result;

/***
 * @author yuefeng
 */
public interface IInsertController<T> {
    /**
     * 添加记录
     * @param record
     * @return
     */
    Result insert(T record);

}
