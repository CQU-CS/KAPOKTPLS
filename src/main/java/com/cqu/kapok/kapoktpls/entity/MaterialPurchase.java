package com.cqu.kapok.kapoktpls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (MaterialPurchase)实体类
 *
 * @author makejava
 * @since 2022-06-28 21:19:57
 */
public class MaterialPurchase implements Serializable {
    private static final long serialVersionUID = 593549478973890875L;
    /**
     * 物资采购ID
     */
    private Integer materialPurchaseId;
    /**
     * 物资ID
     */
    private Integer materialId;
    /**
     * 采购日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date materialPurchaseDate;
    /**
     * 采购数量
     */
    private Integer materialPurchaseNum;
    /**
     * 采购价格
     */
    private Integer materialPurchasePrice;
    /**
     * 付款状态
     */
    private Integer payStatus;
    /**
     * 采购公司id
     */
    private Integer companyId;


    public Integer getMaterialPurchaseId() {
        return materialPurchaseId;
    }

    public void setMaterialPurchaseId(Integer materialPurchaseId) {
        this.materialPurchaseId = materialPurchaseId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Date getMaterialPurchaseDate() {
        return materialPurchaseDate;
    }

    public void setMaterialPurchaseDate(Date materialPurchaseDate) {
        this.materialPurchaseDate = materialPurchaseDate;
    }

    public Integer getMaterialPurchaseNum() {
        return materialPurchaseNum;
    }

    public void setMaterialPurchaseNum(Integer materialPurchaseNum) {
        this.materialPurchaseNum = materialPurchaseNum;
    }

    public Integer getMaterialPurchasePrice() {
        return materialPurchasePrice;
    }

    public void setMaterialPurchasePrice(Integer materialPurchasePrice) {
        this.materialPurchasePrice = materialPurchasePrice;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

}

