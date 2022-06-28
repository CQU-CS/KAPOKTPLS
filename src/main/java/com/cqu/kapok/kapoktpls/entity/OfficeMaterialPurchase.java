package com.cqu.kapok.kapoktpls.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (OfficeMaterialPurchase)实体类
 *
 * @author makejava
 * @since 2022-06-28 09:44:07
 */
public class OfficeMaterialPurchase implements Serializable {
    private static final long serialVersionUID = -63861190681276764L;
    /**
     * 办公耗材采购id
     */
    private Integer officeMaterialPurchaseId;
    /**
     * 办公耗材名称
     */
    private String officeMaterialName;
    /**
     * 采购公司id
     */
    private Integer companyId;
    /**
     * 采购价格
     */
    private Integer officeMaterialPurchasePrice;
    /**
     * 采购日期
     */
    private Date officeMaterialPurchaseDate;
    /**
     * 付款状态
     */
    private Integer payState;


    public Integer getOfficeMaterialPurchaseId() {
        return officeMaterialPurchaseId;
    }

    public void setOfficeMaterialPurchaseId(Integer officeMaterialPurchaseId) {
        this.officeMaterialPurchaseId = officeMaterialPurchaseId;
    }

    public String getOfficeMaterialName() {
        return officeMaterialName;
    }

    public void setOfficeMaterialName(String officeMaterialName) {
        this.officeMaterialName = officeMaterialName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getOfficeMaterialPurchasePrice() {
        return officeMaterialPurchasePrice;
    }

    public void setOfficeMaterialPurchasePrice(Integer officeMaterialPurchasePrice) {
        this.officeMaterialPurchasePrice = officeMaterialPurchasePrice;
    }

    public Date getOfficeMaterialPurchaseDate() {
        return officeMaterialPurchaseDate;
    }

    public void setOfficeMaterialPurchaseDate(Date officeMaterialPurchaseDate) {
        this.officeMaterialPurchaseDate = officeMaterialPurchaseDate;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

}

