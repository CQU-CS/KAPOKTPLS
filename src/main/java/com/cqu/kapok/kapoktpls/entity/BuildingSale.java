package com.cqu.kapok.kapoktpls.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (BuildingSale)实体类
 *
 * @author makejava
 * @since 2022-06-28 08:57:16
 */
public class BuildingSale implements Serializable {
    private static final long serialVersionUID = 541212350710547897L;
    /**
     * 建筑构物出售ID
     */
    private Integer buildingSaleId;
    /**
     * 建筑构物ID
     */
    private Integer buildingId;
    /**
     * 公司ID
     */
    private Integer companyId;
    /**
     * 出售数量
     */
    private Integer buildingSaleNum;
    /**
     * 出售价格
     */
    private Integer buildingSalePrice;
    /**
     * 出售日期
     */
    private Date buildingSaleDate;
    /**
     * 付款状态
     */
    private Integer payStatus;


    public Integer getBuildingSaleId() {
        return buildingSaleId;
    }

    public void setBuildingSaleId(Integer buildingSaleId) {
        this.buildingSaleId = buildingSaleId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getBuildingSaleNum() {
        return buildingSaleNum;
    }

    public void setBuildingSaleNum(Integer buildingSaleNum) {
        this.buildingSaleNum = buildingSaleNum;
    }

    public Integer getBuildingSalePrice() {
        return buildingSalePrice;
    }

    public void setBuildingSalePrice(Integer buildingSalePrice) {
        this.buildingSalePrice = buildingSalePrice;
    }

    public Date getBuildingSaleDate() {
        return buildingSaleDate;
    }

    public void setBuildingSaleDate(Date buildingSaleDate) {
        this.buildingSaleDate = buildingSaleDate;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

}

