package com.cqu.kapok.kapoktpls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Building)实体类
 *
 * @author makejava
 * @since 2022-06-28 08:56:47
 */
public class Building implements Serializable {
    private static final long serialVersionUID = -33981995993932703L;
    /**
     * 建筑构物id
     */
    private Integer buildingId;
    /**
     * 地址id
     */
    private Integer addressId;
    /**
     * 建筑构物类型
     */
    private String buildingType;
    /**
     * 建筑构物名称
     */
    private String buildingName;
    /**
     * 建筑构物购买时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date buildingBuyTime;


    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Date getBuildingBuyTime() {
        return buildingBuyTime;
    }

    public void setBuildingBuyTime(Date buildingBuyTime) {
        this.buildingBuyTime = buildingBuyTime;
    }

}

