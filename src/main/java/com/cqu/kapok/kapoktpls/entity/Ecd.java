package com.cqu.kapok.kapoktpls.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Ecd)实体类
 *
 * @author makejava
 * @since 2022-06-28 14:49:10
 */
public class Ecd implements Serializable {
    private static final long serialVersionUID = -66221091993339923L;
    /**
     * 主键id
     */
    private Integer ecdId;
    /**
     * 机电设备名称
     */
    private String ecdName;
    /**
     * 规格参数
     */
    private String ecdSpecification;
    /**
     * 购买价格
     */
    private Integer ecdPrice;
    /**
     * 购买日期
     */
    private Date ecdDate;
    /**
     * 生产厂家
     */
    private String ecdManufacturers;
    /**
     * 存放建筑构物id
     */
    private Integer buildingId;


    public Integer getEcdId() {
        return ecdId;
    }

    public void setEcdId(Integer ecdId) {
        this.ecdId = ecdId;
    }

    public String getEcdName() {
        return ecdName;
    }

    public void setEcdName(String ecdName) {
        this.ecdName = ecdName;
    }

    public String getEcdSpecification() {
        return ecdSpecification;
    }

    public void setEcdSpecification(String ecdSpecification) {
        this.ecdSpecification = ecdSpecification;
    }

    public Integer getEcdPrice() {
        return ecdPrice;
    }

    public void setEcdPrice(Integer ecdPrice) {
        this.ecdPrice = ecdPrice;
    }

    public Date getEcdDate() {
        return ecdDate;
    }

    public void setEcdDate(Date ecdDate) {
        this.ecdDate = ecdDate;
    }

    public String getEcdManufacturers() {
        return ecdManufacturers;
    }

    public void setEcdManufacturers(String ecdManufacturers) {
        this.ecdManufacturers = ecdManufacturers;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

}

