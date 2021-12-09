package com.yuefeng.goods.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuefeng.goods.dao.CategoryMapper;
import com.yuefeng.pojo.Category;
import com.yuefeng.pojo.Para;
import com.yuefeng.goods.dao.ParaMapper;
import com.yuefeng.goods.service.ParaService;
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
public class ParaServiceImpl extends ServiceImpl<ParaMapper, Para> implements ParaService {


    @Autowired
    ParaMapper paraMapper;

    @Autowired
    CategoryMapper categoryMapper;

    /***
     * 根据分类ID查询参数列表
     * @param id
     * @return
     */
    @Override
    public List<Para> findByCategoryId(Integer id) {
        //查询分类信息
        Category category = categoryMapper.selectById(id);
        //根据分类的模板ID查询参数列表
        Para para = new Para();
        para.setTemplateId(category.getTemplateId());
        return paraMapper.selectList(new QueryWrapper<>(para));
    }
}
