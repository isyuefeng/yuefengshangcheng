package com.yuefeng.goods.service.imp;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.yuefeng.goods.dao.BrandMapper;
import com.yuefeng.goods.dao.CategoryMapper;
import com.yuefeng.goods.dao.SkuMapper;
import com.yuefeng.pojo.*;
import com.yuefeng.goods.dao.SpuMapper;
import com.yuefeng.goods.service.SpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 *
 * @author yuefeng
 * @since 2021-12-09
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements SpuService {


    @Autowired
    SpuMapper spuMapper;


    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SkuMapper skuMapper;

    /***
     * 保存Goods
     * @param goods
     */
    @Override
    public void saveGoods(Goods goods) {
        //增加Spu
        Spu spu = goods.getSpu();

        if (spu.getId() == null) {
            //增加
            spu.setId(IdWorker.getIdStr());
            spuMapper.insert(spu);
        } else {
            //修改数据
            spuMapper.updateById(spu);
            //删除该Spu的Sku
            Sku sku = new Sku();
            sku.setSpuId(spu.getId());
            skuMapper.delete(new QueryWrapper<>(sku));
        }
        //增加Sku
        Date date = new Date();
        Category category = categoryMapper.selectById(spu.getCategory3Id());
        Brand brand = brandMapper.selectById(spu.getBrandId());
        //获取Sku集合
        List<Sku> skus = goods.getSkuList();
        //循环将数据加入到数据库
        for (Sku sku : skus) {
            //构建SKU名称，采用SPU+规格值组装
            if (StringUtils.isEmpty(sku.getSpec())) {
                sku.setSpec("{}");
            }
            //获取Spu的名字
            String name = spu.getName();

            //将规格转换成Map
            Map<String, String> specMap = JSON.parseObject(sku.getSpec(), Map.class);
            //循环组装Sku的名字
            for (Map.Entry<String, String> entry : specMap.entrySet()) {
                name += "  " + entry.getValue();
            }
            sku.setName(name);
            //ID
            sku.setId(IdWorker.getIdStr());
            //SpuId
            sku.setSpuId(spu.getId());
            //创建日期
            sku.setCreateTime(date);
            //修改日期
            sku.setUpdateTime(date);
            //商品分类ID
            sku.setCategoryId(spu.getCategory3Id());
            //分类名字
            sku.setCategoryName(category.getName());
            //品牌名字
            sku.setBrandName(brand.getName());
            //增加
            skuMapper.insert(sku);
        }
    }

    /***
     * 根据SpuID查询goods信息
     * @param spuId
     * @return
     */
    @Override
    public Goods findGoodsById(Long spuId) {
        //查询Spu
        Spu spu = spuMapper.selectById(spuId);

        //查询List<Sku>
        Sku sku = new Sku();

        sku.setSpuId(String.valueOf(spuId));
        List<Sku> skus = skuMapper.selectList(new QueryWrapper<>(sku));
        //封装Goods
        Goods goods = new Goods();
        goods.setSkuList(skus);
        goods.setSpu(spu);
        return goods;
    }

    /***
     * 商品审核
     * @param spuId
     */
    @Override
    public void audit(Long spuId) {
        //查询商品
        Spu spu = spuMapper.selectById(spuId);
        //判断商品是否已经删除
        if (spu.getIsDelete().equalsIgnoreCase("1")) {
            throw new RuntimeException("该商品已经删除！");
        }
        //实现审核
        spu.setStatus("1"); //审核通过
        spuMapper.updateById(spu);
    }

    /**
     * 商品下架
     *
     * @param spuId
     */
    @Override
    public void pull(Long spuId) {
        Spu spu = spuMapper.selectById(spuId);
        if (spu.getIsDelete().equals("1")) {
            throw new RuntimeException("此商品已删除！");
        }
        spu.setIsMarketable("0");//下架状态
        spuMapper.updateById(spu);
    }

    /***
     * 商品上架
     * @param spuId
     */
    @Override
    public void put(Long spuId) {
        Spu spu = spuMapper.selectById(spuId);
        //检查是否删除的商品
        if (spu.getIsDelete().equals("1")) {
            throw new RuntimeException("此商品已删除！");
        }
        //上架状态
        spu.setIsMarketable("1");
        spuMapper.updateById(spu);
    }

    /***
     * 批量上架
     * @param ids:需要上架的商品ID集合
     * @return
     */
    @Override
    public int putMany(Long[] ids) {
        List<Long> longs = Arrays.asList(ids);
        Spu spu = new Spu();

        spu.setIsMarketable("1");//上架
        //批量修改
        UpdateWrapper<Spu> updateWrapper = new UpdateWrapper<>();

        updateWrapper.in("id", longs);
        updateWrapper.eq("is_Marketable", "0");
        updateWrapper.eq("status", "1");
        updateWrapper.eq("is_Delete", "0");

        int update = spuMapper.update(spu, updateWrapper);

        return update;
    }

    /***
     * 批量上架
     * @param ids:需要下架的商品ID集合
     * @return
     */
    @Override
    public void pullMany(Long[] ids) {
        for (Long id : ids) {
            Spu spu = spuMapper.selectById(id);
            if (spu.getIsDelete().equals("1")) {
                throw new RuntimeException("此商品已删除！");
            }
            spu.setIsMarketable("0");//下架状态
            spuMapper.updateById(spu);
        }
    }


    /***
     * 逻辑删除
     * @param spuId
     */
    @Override
    @Transactional
    public void logicDelete(Long spuId) {
        Spu spu = spuMapper.selectById(spuId);
        //检查是否下架的商品
        if(!spu.getIsMarketable().equals("0")){
            throw new RuntimeException("必须先下架再删除！");
        }
        //删除
        spu.setIsDelete("1");
        //未审核
        spu.setStatus("0");
        spuMapper.updateById(spu);
    }


    /**
     * 恢复数据
     * @param spuId
     */
    @Override
    public void restore(Long spuId) {
        Spu spu = spuMapper.selectById(spuId);
        //检查是否删除的商品
        if(!spu.getIsDelete().equals("1")){
            throw new RuntimeException("此商品未删除！");
        }
        //未删除
        spu.setIsDelete("0");
        //未审核
        spu.setStatus("0");
        spuMapper.updateById(spu);
    }





}
