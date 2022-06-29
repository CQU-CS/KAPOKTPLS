package com.cqu.kapok.kapoktpls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (TruckSale)实体类
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
public class TruckSale implements Serializable {
    private static final long serialVersionUID = -31291427398001814L;
    /**
     * 汽车销售ID
     */
    private Integer truckSaleId;
    /**
     * 汽车ID
     */
    private Integer truckId;
    /**
     * 公司ID
     */
    private Integer companyId;
    /**
     * 汽车销售数量
     */
    private Integer truckSaleNum;
    /**
     * 汽车销售价格
     */
    private Integer truckSalePrice;
    /**
     * 采购日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date truckSaleDate;
    /**
     * 付款状态
     */
    private Integer payStatus;


    public Integer getTruckSaleId() {
        return truckSaleId;
    }

    public void setTruckSaleId(Integer truckSaleId) {
        this.truckSaleId = truckSaleId;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getTruckSaleNum() {
        return truckSaleNum;
    }

    public void setTruckSaleNum(Integer truckSaleNum) {
        this.truckSaleNum = truckSaleNum;
    }

    public Integer getTruckSalePrice() {
        return truckSalePrice;
    }

    public void setTruckSalePrice(Integer truckSalePrice) {
        this.truckSalePrice = truckSalePrice;
    }

    public Date getTruckSaleDate() {
        return truckSaleDate;
    }

    public void setTruckSaleDate(Date truckSaleDate) {
        this.truckSaleDate = truckSaleDate;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

}

