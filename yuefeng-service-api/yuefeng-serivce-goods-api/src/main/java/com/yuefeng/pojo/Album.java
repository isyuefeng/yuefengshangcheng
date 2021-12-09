package com.yuefeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 *
 *
 *
 *
 * @author yuefeng
 * @since 2021-12-09
 */
@TableName("tb_album")
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 相册名称
     */
    private String title;

    /**
     * 相册封面
     */
    private String image;

    /**
     * 图片列表
     */
    private String imageItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getImageItems() {
        return imageItems;
    }

    public void setImageItems(String imageItems) {
        this.imageItems = imageItems;
    }

    @Override
    public String toString() {
        return "Album{" +
            "id=" + id +
            ", title=" + title +
            ", image=" + image +
            ", imageItems=" + imageItems +
        "}";
    }
}
