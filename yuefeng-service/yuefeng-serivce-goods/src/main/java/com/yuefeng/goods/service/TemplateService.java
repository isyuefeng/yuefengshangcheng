package com.yuefeng.goods.service;

import com.yuefeng.pojo.Template;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 *  服务类
 *
 *
 * @author yuefeng
 * @since 2021-12-09
 */
public interface TemplateService extends IService<Template> {

    Template findByCategoryId(Integer id);
}
