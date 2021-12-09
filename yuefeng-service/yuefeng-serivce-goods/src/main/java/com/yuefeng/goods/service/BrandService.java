package com.yuefeng.goods.service;

import com.yuefeng.pojo.Brand;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 * 品牌表 服务类
 *
 *
 * @author yuefeng
 * @since 2021-12-09
 */
public interface BrandService extends IService<Brand> {
    /***
     * 根据分类实现品牌列表查询
     * /brand/category/{id}  分类ID
     */
    List<Brand> findByCategory(Integer categoryId);
}
