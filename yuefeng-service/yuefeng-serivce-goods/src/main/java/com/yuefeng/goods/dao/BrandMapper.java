package com.yuefeng.goods.dao;

import com.yuefeng.pojo.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * 品牌表 Mapper 接口
 *
 *
 * @author yuefeng
 * @since 2021-12-09
 */
public interface BrandMapper extends BaseMapper<Brand> {
    /***
     * 查询分类对应的品牌集合
     */
    @Select("SELECT tb.* FROM tb_category_brand tcb,tb_brand tb WHERE tcb.category_id=#{categoryid} AND tb.id=tcb.brand_id")
    List<Brand> findByCategory(Integer categoryid);
}
