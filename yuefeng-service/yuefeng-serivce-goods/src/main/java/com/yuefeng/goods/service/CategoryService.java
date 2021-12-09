package com.yuefeng.goods.service;

import com.yuefeng.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 * 商品类目 服务类
 *
 *
 * @author yuefeng
 * @since 2021-12-09
 */
public interface CategoryService extends IService<Category> {
    /**
     * 根据节点ID查询所有子节点分类集合
     * @param pid
     * @return
     */
    List<Category> findByParentId(Integer pid);
}
