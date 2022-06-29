package com.cqu.kapok.kapoktpls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (TruckPurchase)实体类
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public class TruckPurchase implements Serializable {
    private static final long serialVersionUID = -81262002515449240L;
    /**
     * 汽车采购ID
     */
    private Integer truckPurchaseId;
    /**
     * 汽车ID
     */
    private Integer truckId;
    /**
     * 采购汽车数量
     */
    private Integer truckPurchaseNum;
    /**
     * 采购价格
     */
    private Integer truckPurchasePrice;
    /**
     * 采购公司ID
     */
    private Integer companyId;
    /**
     * 采购日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date truckPurchaseDate;
    /**
     * 付款状态
     */
    private Integer payStatus;


    public Integer getTruckPurchaseId() {
        return truckPurchaseId;
    }

    public void setTruckPurchaseId(Integer truckPurchaseId) {
        this.truckPurchaseId = truckPurchaseId;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public Integer getTruckPurchaseNum() {
        return truckPurchaseNum;
    }

    public void setTruckPurchaseNum(Integer truckPurchaseNum) {
        this.truckPurchaseNum = truckPurchaseNum;
    }

    public Integer getTruckPurchasePrice() {
        return truckPurchasePrice;
    }

    public void setTruckPurchasePrice(Integer truckPurchasePrice) {
        this.truckPurchasePrice = truckPurchasePrice;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getTruckPurchaseDate() {
        return truckPurchaseDate;
    }

    public void setTruckPurchaseDate(Date truckPurchaseDate) {
        this.truckPurchaseDate = truckPurchaseDate;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

}

