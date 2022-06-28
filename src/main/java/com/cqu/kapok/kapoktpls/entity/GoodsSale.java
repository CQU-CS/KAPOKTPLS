package com.cqu.kapok.kapoktpls.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (GoodsSale)实体类
 *
 * @author makejava
 * @since 2022-06-28 21:18:45
 */
public class GoodsSale implements Serializable {
    private static final long serialVersionUID = -45783467815938955L;
    /**
     * 货物销售ID
     */
    private Integer goodsSaleId;
    /**
     * 货物ID
     */
    private Integer goodsId;
    /**
     * 公司ID
     */
    private Integer companyId;
    /**
     * 货物销售数量
     */
    private Integer goodsSaleNum;
    /**
     * 货物销售价格
     */
    private Integer goodsSalePrice;
    /**
     * 货物销售日期
     */
    private Date goodsSaleDate;
    /**
     * 收款状态
     */
    private Integer payStatus;


    public Integer getGoodsSaleId() {
        return goodsSaleId;
    }

    public void setGoodsSaleId(Integer goodsSaleId) {
        this.goodsSaleId = goodsSaleId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getGoodsSaleNum() {
        return goodsSaleNum;
    }

    public void setGoodsSaleNum(Integer goodsSaleNum) {
        this.goodsSaleNum = goodsSaleNum;
    }

    public Integer getGoodsSalePrice() {
        return goodsSalePrice;
    }

    public void setGoodsSalePrice(Integer goodsSalePrice) {
        this.goodsSalePrice = goodsSalePrice;
    }

    public Date getGoodsSaleDate() {
        return goodsSaleDate;
    }

    public void setGoodsSaleDate(Date goodsSaleDate) {
        this.goodsSaleDate = goodsSaleDate;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

}

