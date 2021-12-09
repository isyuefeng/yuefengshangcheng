package com.yuefeng.goods.service.imp;

import com.yuefeng.pojo.Album;
import com.yuefeng.goods.dao.AlbumMapper;
import com.yuefeng.goods.service.AlbumService;
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
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements AlbumService {


    @Autowired
    AlbumMapper albumMapper;
}
