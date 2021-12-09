package com.yuefeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 *
 * 商品类目
 *
 *
 * @author yuefeng
 * @since 2021-12-09
 */
@TableName("tb_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分类ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 是否显示
     */
    private String isShow;

    /**
     * 是否导航
     */
    private String isMenu;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 上级ID
     */
    private Integer parentId;

    /**
     * 模板ID
     */
    private Integer templateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }
    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @Override
    public String toString() {
        return "Category{" +
            "id=" + id +
            ", name=" + name +
            ", goodsNum=" + goodsNum +
            ", isShow=" + isShow +
            ", isMenu=" + isMenu +
            ", seq=" + seq +
            ", parentId=" + parentId +
            ", templateId=" + templateId +
        "}";
    }
}
