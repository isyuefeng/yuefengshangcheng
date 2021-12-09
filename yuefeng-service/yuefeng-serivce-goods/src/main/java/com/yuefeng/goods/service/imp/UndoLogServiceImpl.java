package com.yuefeng.goods.service.imp;

import com.yuefeng.pojo.UndoLog;
import com.yuefeng.goods.dao.UndoLogMapper;
import com.yuefeng.goods.service.UndoLogService;
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
public class UndoLogServiceImpl extends ServiceImpl<UndoLogMapper, UndoLog> implements UndoLogService {


    @Autowired
    UndoLogMapper undoLogMapper;
}
