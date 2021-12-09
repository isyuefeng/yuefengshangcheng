package com.yuefeng.goods.service.imp;

import com.yuefeng.pojo.Pref;
import com.yuefeng.goods.dao.PrefMapper;
import com.yuefeng.goods.service.PrefService;
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
public class PrefServiceImpl extends ServiceImpl<PrefMapper, Pref> implements PrefService {


    @Autowired
    PrefMapper prefMapper;
}
