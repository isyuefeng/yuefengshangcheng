package com.yuefeng.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author yf
 * @date 2021/12/9
 **/
public class Goods implements Serializable {
    //SPU
    private Spu spu;
    //SKU集合
    private List<Sku> skuList;

    @Override
    public String toString() {
        return "Goods{" +
                "spu=" + spu +
                ", skuList=" + skuList +
                '}';
    }

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }

    //..get..set..toString
}
