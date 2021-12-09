package com.yuefeng.goods.service;

import com.yuefeng.pojo.Spec;
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
public interface SpecService extends IService<Spec> {
    /***
     * 根据分类ID查询对应的规格列表
     */
    List<Spec> findByCategoryId(Integer categoryid);
}
