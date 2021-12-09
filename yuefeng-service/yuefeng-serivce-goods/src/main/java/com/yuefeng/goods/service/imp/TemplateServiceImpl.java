package com.yuefeng.goods.service.imp;

import com.yuefeng.goods.dao.CategoryMapper;
import com.yuefeng.pojo.Category;
import com.yuefeng.pojo.Template;
import com.yuefeng.goods.dao.TemplateMapper;
import com.yuefeng.goods.service.TemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
*
*  服务实现类
*
*
* @author yuefeng
* @since 2021-12-09
*/
@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, Template> implements TemplateService {


    @Autowired
    TemplateMapper templateMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    /***
     * 根据分类ID查询模板信息
     * @param id
     * @return
     */
    @Override
    public Template findByCategoryId(Integer id) {
        //查询分类信息
        Category category = categoryMapper.selectById(id);

        //根据模板Id查询模板信息
        return templateMapper.selectById(category.getTemplateId());
    }
}
