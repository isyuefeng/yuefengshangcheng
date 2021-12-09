package com.yuefeng.goods.service.imp;

import com.yuefeng.pojo.Sku;
import com.yuefeng.goods.dao.SkuMapper;
import com.yuefeng.goods.service.SkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
*
* 商品表 服务实现类
*
*
* @author yuefeng
* @since 2021-12-09
*/
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {


    @Autowired
    SkuMapper skuMapper;
}
