package com.cqu.kapok.kapoktpls.entity;

import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2022-06-28 15:04:47
 */
public class Goods implements Serializable {
    private static final long serialVersionUID = -78486002940455655L;
    /**
     * 主键id
     */
    private Integer goodsId;
    /**
     * 类别
     */
    private String goodsType;
    /**
     * 名称
     */
    private String goodsName;
    /**
     * 单位
     */
    private String goodsUnit;
    /**
     * 参数规格
     */
    private String goodsSpecification;
    /**
     * 单位价格
     */
    private Integer goodsUnitPrice;


    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsSpecification() {
        return goodsSpecification;
    }

    public void setGoodsSpecification(String goodsSpecification) {
        this.goodsSpecification = goodsSpecification;
    }

    public Integer getGoodsUnitPrice() {
        return goodsUnitPrice;
    }

    public void setGoodsUnitPrice(Integer goodsUnitPrice) {
        this.goodsUnitPrice = goodsUnitPrice;
    }

}

