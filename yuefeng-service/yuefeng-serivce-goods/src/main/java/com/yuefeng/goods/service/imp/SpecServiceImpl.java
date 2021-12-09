package com.yuefeng.goods.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuefeng.goods.dao.CategoryMapper;
import com.yuefeng.pojo.Category;
import com.yuefeng.pojo.Spec;
import com.yuefeng.goods.dao.SpecMapper;
import com.yuefeng.goods.service.SpecService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
*
*  服务实现类
*
*
* @author yuefeng
* @since 2021-12-09
*/
@Service
public class SpecServiceImpl extends ServiceImpl<SpecMapper, Spec> implements SpecService {


    @Autowired
    SpecMapper specMapper;


    @Autowired
    private CategoryMapper categoryMapper;

    /***
     * 根据分类ID查询规格列表
     * @param categoryid
     * @return
     */
    @Override
    public List<Spec> findByCategoryId(Integer categoryid) {
        //查询分类
        Category category = categoryMapper.selectById(categoryid);
        //根据分类的模板ID查询规格
        Spec spec = new Spec();
        spec.setTemplateId(category.getTemplateId());
        return specMapper.selectList(new QueryWrapper<>(spec));
    }
}
