package com.yuefeng.goods.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuefeng.pojo.Category;
import com.yuefeng.goods.dao.CategoryMapper;
import com.yuefeng.goods.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
*
* 商品类目 服务实现类
*
*
* @author yuefeng
* @since 2021-12-09
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 根据节点ID查询所有子节点分类集合
     * @param pid
     * @return
     */
    @Override
    public List<Category> findByParentId(Integer pid) {
        //SELECT * FROM tb_category WHERE parent_id=?
        Category category = new Category();
        category.setParentId(pid);
        return categoryMapper.selectList(new QueryWrapper<>(category));
    }
}
