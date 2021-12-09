package com.yuefeng.goods.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuefeng.pojo.Brand;
import com.yuefeng.goods.dao.BrandMapper;
import com.yuefeng.goods.service.BrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
*
* 品牌表 服务实现类
*
*
* @author yuefeng
* @since 2021-12-09
*/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {


    @Autowired
    BrandMapper brandMapper;


    @Override
    public List<Brand> findByCategory(Integer categoryid) {
        //1.查询当前分类所对应的所有品牌信息
        //2.根据品牌ID查询对应的品牌集合

        //自己创建DAO实现查询
        return brandMapper.findByCategory(categoryid);
    }
}
