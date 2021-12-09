package com.yuefeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 *
 *
 *
 * @author yuefeng
 * @since 2021-12-09
 */
@TableName("tb_pref")
public class Pref implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类ID
     */
    private Integer cateId;

    /**
     * 消费金额
     */
    private Integer buyMoney;

    /**
     * 优惠金额
     */
    private Integer preMoney;

    /**
     * 活动开始日期
     */
    private LocalDate startTime;

    /**
     * 活动截至日期
     */
    private LocalDate endTime;

    /**
     * 类型
     */
    private String type;

    /**
     * 状态
     */
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }
    public Integer getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(Integer buyMoney) {
        this.buyMoney = buyMoney;
    }
    public Integer getPreMoney() {
        return preMoney;
    }

    public void setPreMoney(Integer preMoney) {
        this.preMoney = preMoney;
    }
    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }
    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Pref{" +
            "id=" + id +
            ", cateId=" + cateId +
            ", buyMoney=" + buyMoney +
            ", preMoney=" + preMoney +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", type=" + type +
            ", state=" + state +
        "}";
    }
}
