package com.yuefeng.goods.service;

import com.yuefeng.pojo.Spu;
import com.yuefeng.pojo.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 *  服务类
 *
 *
 * @author yuefeng
 * @since 2021-12-09
 */
public interface SpuService extends IService<Spu> {
    /***
     * 添加Goods
     * @param goods
     * @return
     */
    void saveGoods(Goods goods);

    /***
     * 根据ID查询Goods
     * @param id
     * @return
     */
    Goods findGoodsById(Long id);

    /**
     * 审核
     * @param id
     * @return
     */
    void audit(Long id);

    /**
     * 下架
     * @param id
     * @return
     */
    void pull(Long id);



    /**
     * 上架
     * @param id
     * @return
     */
    void put(Long id);

    /**
     *  批量上架
     * @param ids
     * @return
     */
    int putMany(Long[] ids);

    /**
     *  批量下架
     * @param ids
     * @return
     */
    void pullMany(Long[] ids);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    void logicDelete(Long id);

    /**
     * 恢复数据
     * @param id
     * @return
     */
    void restore(Long id);
}
