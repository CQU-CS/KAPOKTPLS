package com.cqu.kapok.kapoktpls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (MaterialSale)实体类
 *
 * @author makejava
 * @since 2022-06-28 09:40:15
 */
public class MaterialSale implements Serializable {
    private static final long serialVersionUID = 431880326453098820L;
    /**
     * 物资销售ID
     */
    private Integer materialSaleId;
    /**
     * 物资ID
     */
    private Integer materialId;
    /**
     * 销售公司ID
     */
    private Integer companyId;
    /**
     * 销售日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date materialSaleDate;
    /**
     * 销售数量
     */
    private Integer materialSaleNum;
    /**
     * 销售价格
     */
    private Integer materialSalePrice;
    /**
     * 收款状态
     */
    private Integer payStatus;


    public Integer getMaterialSaleId() {
        return materialSaleId;
    }

    public void setMaterialSaleId(Integer materialSaleId) {
        this.materialSaleId = materialSaleId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getMaterialSaleDate() {
        return materialSaleDate;
    }

    public void setMaterialSaleDate(Date materialSaleDate) {
        this.materialSaleDate = materialSaleDate;
    }

    public Integer getMaterialSaleNum() {
        return materialSaleNum;
    }

    public void setMaterialSaleNum(Integer materialSaleNum) {
        this.materialSaleNum = materialSaleNum;
    }

    public Integer getMaterialSalePrice() {
        return materialSalePrice;
    }

    public void setMaterialSalePrice(Integer materialSalePrice) {
        this.materialSalePrice = materialSalePrice;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

}

