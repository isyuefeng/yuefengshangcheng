package com.yuefeng.goods.service;

import com.yuefeng.pojo.Para;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 *  服务类
 *
 *
 * @author yuefeng
 * @since 2021-12-09
 */
public interface ParaService extends IService<Para> {

    /**
     * 根据分类ID查询参数列表
     * @param id
     * @return
     */
    List<Para> findByCategoryId(Integer id);
}
