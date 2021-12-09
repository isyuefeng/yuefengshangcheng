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
@TableName("tb_template")
public class Template implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 规格数量
     */
    private Integer specNum;

    /**
     * 参数数量
     */
    private Integer paraNum;

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
    public Integer getSpecNum() {
        return specNum;
    }

    public void setSpecNum(Integer specNum) {
        this.specNum = specNum;
    }
    public Integer getParaNum() {
        return paraNum;
    }

    public void setParaNum(Integer paraNum) {
        this.paraNum = paraNum;
    }

    @Override
    public String toString() {
        return "Template{" +
            "id=" + id +
            ", name=" + name +
            ", specNum=" + specNum +
            ", paraNum=" + paraNum +
        "}";
    }
}
