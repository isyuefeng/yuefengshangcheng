package com.yuefeng.goods.service.imp;

import com.yuefeng.pojo.CategoryBrand;
import com.yuefeng.goods.dao.CategoryBrandMapper;
import com.yuefeng.goods.service.CategoryBrandService;
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
public class CategoryBrandServiceImpl extends ServiceImpl<CategoryBrandMapper, CategoryBrand> implements CategoryBrandService {


    @Autowired
    CategoryBrandMapper categoryBrandMapper;
}
