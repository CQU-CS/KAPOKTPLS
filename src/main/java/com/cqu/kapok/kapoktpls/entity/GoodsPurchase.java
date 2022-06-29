package com.cqu.kapok.kapoktpls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (GoodsPurchase)实体类
 *
 * @author makejava
 * @since 2022-06-28 21:11:50
 */
public class GoodsPurchase implements Serializable {
    private static final long serialVersionUID = 565607177197369039L;
    /**
     * 货物采购ID
     */
    private Integer goodsPurchaseId;
    /**
     * 货物ID
     */
    private Integer goodsId;
    /**
     * 采购公司ID
     */
    private Integer companyId;
    /**
     * 采购数量
     */
    private Integer goodsPurchaseNum;
    /**
     * 采购价格
     */
    private Integer goodsPurchasePrice;
    /**
     * 采购日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date goodsPurchaseDate;
    /**
     * 付款状态
     */
    private Integer payStatus;


    public Integer getGoodsPurchaseId() {
        return goodsPurchaseId;
    }

    public void setGoodsPurchaseId(Integer goodsPurchaseId) {
        this.goodsPurchaseId = goodsPurchaseId;
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

    public Integer getGoodsPurchaseNum() {
        return goodsPurchaseNum;
    }

    public void setGoodsPurchaseNum(Integer goodsPurchaseNum) {
        this.goodsPurchaseNum = goodsPurchaseNum;
    }

    public Integer getGoodsPurchasePrice() {
        return goodsPurchasePrice;
    }

    public void setGoodsPurchasePrice(Integer goodsPurchasePrice) {
        this.goodsPurchasePrice = goodsPurchasePrice;
    }

    public Date getGoodsPurchaseDate() {
        return goodsPurchaseDate;
    }

    public void setGoodsPurchaseDate(Date goodsPurchaseDate) {
        this.goodsPurchaseDate = goodsPurchaseDate;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

}

