package com.yuefeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 *
 * 品牌表
 *
 *
 * @author yuefeng
 * @since 2021-12-09
 */
@TableName("tb_brand")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌图片地址
     */
    private String image;

    /**
     * 品牌的首字母
     */
    private String letter;

    /**
     * 排序
     */
    private Integer seq;

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
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "Brand{" +
            "id=" + id +
            ", name=" + name +
            ", image=" + image +
            ", letter=" + letter +
            ", seq=" + seq +
        "}";
    }
}
