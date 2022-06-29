package com.cqu.kapok.kapoktpls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (BuildingRent)实体类
 *
 * @author makejava
 * @since 2022-06-28 08:57:05
 */
public class BuildingRent implements Serializable {
    private static final long serialVersionUID = 687267541365735474L;
    /**
     * 建筑构物租赁ID
     */
    private Integer buildingRentId;
    /**
     * 建筑构物ID
     */
    private Integer buildingId;
    /**
     * 租借公司ID
     */
    private Integer companyId;
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date buildingRentStartTime;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date buildingRentEndTime;
    /**
     * 租赁价格
     */
    private Integer buildingRentPrice;
    /**
     * 付款状态
     */
    private Integer payStatus;


    public Integer getBuildingRentId() {
        return buildingRentId;
    }

    public void setBuildingRentId(Integer buildingRentId) {
        this.buildingRentId = buildingRentId;
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

    public Date getBuildingRentStartTime() {
        return buildingRentStartTime;
    }

    public void setBuildingRentStartTime(Date buildingRentStartTime) {
        this.buildingRentStartTime = buildingRentStartTime;
    }

    public Date getBuildingRentEndTime() {
        return buildingRentEndTime;
    }

    public void setBuildingRentEndTime(Date buildingRentEndTime) {
        this.buildingRentEndTime = buildingRentEndTime;
    }

    public Integer getBuildingRentPrice() {
        return buildingRentPrice;
    }

    public void setBuildingRentPrice(Integer buildingRentPrice) {
        this.buildingRentPrice = buildingRentPrice;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

}

