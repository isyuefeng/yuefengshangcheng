package com.yuefeng.core;

import com.baomidou.mybatisplus.core.metadata.IPage;
import entity.Result;

/**
 * @author yuefeng
 */
public interface IPagingController<T> {

    /**
     * 查询所有并分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<IPage<T>> findByPage(long pageNo, long pageSize);


    /**
     * 根据查询条件 record 分页查询
     *
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    Result<IPage<T>> findByPage(long pageNo, long pageSize, T record);


}
